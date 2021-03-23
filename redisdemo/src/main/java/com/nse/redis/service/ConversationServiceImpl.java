package com.nse.redis.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nse.redis.entity.Conversation;
import com.nse.redis.repository.ConversationRepository;

@Service
public class ConversationServiceImpl implements ConversationService{
	private final Logger logger = LoggerFactory.getLogger(ConversationServiceImpl.class);

	@Autowired
	private ConversationRepository conversationRepository;
	
	@Override
	public List<Conversation> getAll() {
		logger.debug(" >> ConversationService : Entering getAll");
		logger.debug(" << ConversationService : Exiting getAll");
		return conversationRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		conversationRepository.deleteById(id);
	}

	

	public Conversation getConversationById(long id) {
		logger.debug(" >> ConversationService : Entering getConversation");
		Optional<Conversation> conversationOp = conversationRepository.findById(id);

		if (conversationOp != null) {
			logger.debug(" << ConversationService : Exiting getConversation");
			return conversationOp.get();
		} else {
			logger.debug(" << ConversationService : No Such Conversation Exists : Exiting getConversation");
			return null;
		}
	}

}
