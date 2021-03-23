package com.nse.redis.service;

import java.util.List;

import com.nse.redis.entity.Conversation;



public interface ConversationService {
	List<Conversation>getAll();
	void delete(Long id);
	Conversation getConversationById(long id);

}
