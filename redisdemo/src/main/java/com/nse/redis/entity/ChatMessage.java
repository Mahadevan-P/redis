package com.nse.redis.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;



@Entity
public class ChatMessage implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long messageId=0;
	private long conversationId;
	private String messageAuthorId;
	private String messageContent;
	@CreationTimestamp
	private LocalDateTime sentAt;
	private Status status=Status.UNREAD;

	public enum Status{
		READ,UNREAD
	}
	public ChatMessage()
	{
		
	}
	
	public ChatMessage(long messageId, long conversationId, String messageAuthorId, String messageContent,
			LocalDateTime sentAt, Status status) {
		super();
		this.messageId = messageId;
		this.conversationId = conversationId;
		this.messageAuthorId = messageAuthorId;
		this.messageContent = messageContent;
		this.sentAt = sentAt;
		this.status = status;
	}
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public long getConversationId() {
		return conversationId;
	}
	public void setConversationId(long conversationId) {
		this.conversationId = conversationId;
	}
	public String getMessageAuthorId() {
		return messageAuthorId;
	}
	public void setMessageAuthorId(String messageAuthorId) {
		this.messageAuthorId = messageAuthorId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public LocalDateTime getSentAt() {
		return sentAt;
	}
	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ChatMessage [messageId=" + messageId + ", conversationId=" + conversationId + ", messageAuthorId="
				+ messageAuthorId + ", messageContent=" + messageContent + ", sentAt=" + sentAt + ", status=" + status
				+ "]";
	}
}
