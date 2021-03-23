package com.nse.redis.service;

import com.nse.redis.entity.GroupChatMessage;

public interface GroupService {

	
GroupChatMessage create(GroupChatMessage groupchatmessage);

	

	void delete(Long id);

	GroupChatMessage getGroupById(long id);
}
