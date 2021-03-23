package com.nse.redis.service;

import java.util.List;

import com.nse.redis.entity.User;

public interface UserService {

	User create(User user);
    User update (User user);
    List<User>getAll();
	

	void delete(Long id);

	User getUserById(long id);

}
