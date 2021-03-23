package com.nse.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nse.redis.entity.GroupChatMessage;

@Repository
public interface GroupRepository  extends   JpaRepository<GroupChatMessage,Long>{
	
	

}
