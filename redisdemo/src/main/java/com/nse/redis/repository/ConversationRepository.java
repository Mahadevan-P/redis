package com.nse.redis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nse.redis.entity.Conversation;
@Repository
public interface ConversationRepository extends JpaRepository<Conversation,Long> {

}
