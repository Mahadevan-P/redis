package com.nse.redis.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nse.redis.entity.Conversation;
import com.nse.redis.entity.User;
import com.nse.redis.service.ConversationServiceImpl;
import com.nse.redis.service.UserServiceImpl;

@RestController
@RequestMapping("/convo")
public class ConversationController {
	private final Logger logger = LoggerFactory.getLogger(ConversationController.class);
	@Autowired
	private ConversationServiceImpl conversationService;
	
	@GetMapping("/conversation/{id}")
	@Cacheable(value = "users", key = "#id")
	public Conversation getConversationById(@PathVariable long id) {
		logger.debug(" >> UserController : /user/{} call : ", id);

		return conversationService.getConversationById(id);

	}
	@DeleteMapping("/delete/{id}")
	@CacheEvict(value = "conversations", allEntries = false, key = "#id")
	public void deleteById(@PathVariable Long id) {
		logger.debug(" >> ConversationController : /delete : ", id);
		conversationService.delete(id);
		logger.debug(" << ConversationController : /delete : ", id);

	}
	@GetMapping("/chatconversations")
	public List<Conversation> getAll() {
		logger.debug(" >> ConversationController : /conversation : ");

		return conversationService.getAll();
	}
}
