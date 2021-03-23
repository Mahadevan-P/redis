package com.nse.redis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.redis.entity.User;

import com.nse.redis.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {
	
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserServiceImpl userService;

	@PostMapping("/user")
	public User create(@RequestBody User user) {
		logger.debug(" >> UserController : /user : ", user.toString());
		return userService.create(user);
	}

	@GetMapping("/user/{id}")
	@Cacheable(value = "users", key = "#id")
	public User getUserById(@PathVariable long id) {
		logger.debug(" >> UserController : /user/{} call : ", id);

		return userService.getUserById(id);

	}

	@DeleteMapping("/delete/{id}")
	@CacheEvict(value = "users", allEntries = false, key = "#id")
	public void deleteById(@PathVariable Long id) {
		logger.debug(" >> UserController : /delete : ", id);
		userService.delete(id);
		logger.debug(" << UserController : /delete : ", id);

	}

	@GetMapping("/users")
	public List<User> getAll() {
		logger.debug(" >> UserController : /users : ");

		return userService.getAll();
	}

	@PutMapping("/update/{id}")
	@CachePut(value = "users", key = "#id")
	public User updateUser(@RequestBody User user,@PathVariable long id) {
		logger.debug(" >> UserController : /update : ", user.toString());
		return userService.update(user);
	}

}
