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

import com.nse.redis.entity.GroupChatMessage;
import com.nse.redis.service.GroupServiceImpl;



@RestController
@RequestMapping("/group")
public class GroupController {
	
private final Logger logger = LoggerFactory.getLogger(GroupController.class);
	
	@Autowired
	private GroupServiceImpl groupService;

	@PostMapping("/groupuser")
	public GroupChatMessage create(@RequestBody GroupChatMessage groupchatmessage) {
		logger.debug(" >> GroupChatMessageController : /groupchatmessage : ", groupchatmessage.toString());
		return groupService.create(groupchatmessage);
	}
	
	@GetMapping("/groupuser/{groupid}")
	@Cacheable(value = "groups", key = "#id")
	public GroupChatMessage getGroupById(@PathVariable long groupid) {
		logger.debug(" >> GroupChatMessageController : /groupchatmessage/{} call : ", groupid);

		return groupService.getGroupById(groupid);

	}

	@DeleteMapping("/delete/{id}")
	@CacheEvict(value = "groups", allEntries = false, key = "#id")
	public void deleteById(@PathVariable Long id) {
		logger.debug(" >> GroupChatMessageController : /delete : ", id);
		groupService.delete(id);
		logger.debug(" << GroupChatMessageController : /delete : ", id);

	}

	@GetMapping("/groups")
	public List<GroupChatMessage> getAll() {
		logger.debug(" >> GroupChatMessageController : /groups : ");

		return groupService.getAll();
	}

}
