package com.nse.redis.service;

import com.nse.redis.entity.ChatMessage;


public interface ChatMessageService {

	ChatMessage create(ChatMessage chatmessage);
	
	void delete(Long messageid);
	
	ChatMessage getChatMessageById(long id);
	
}
