package com.nse.redis.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;



@Entity
public class GroupChatMessage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long groudMessageId=0;
    private long groupId;
    private long messageAuthorId;
    private String messageAuthor;
    private String messageContent;
    @CreationTimestamp
    private LocalDateTime sentAt;
    private ChatMessage.Status status= ChatMessage.Status.UNREAD;

    public enum Status{
        READ,UNREAD
    }
    public GroupChatMessage()
    {
    	
    }
	public GroupChatMessage(long groudMessageId, long groupId, long messageAuthorId, String messageAuthor,
			String messageContent, LocalDateTime sentAt, com.nse.redis.entity.ChatMessage.Status status) {
		super();
		this.groudMessageId = groudMessageId;
		this.groupId = groupId;
		this.messageAuthorId = messageAuthorId;
		this.messageAuthor = messageAuthor;
		this.messageContent = messageContent;
		this.sentAt = sentAt;
		this.status = status;
	}
	public long getGroudMessageId() {
		return groudMessageId;
	}
	public void setGroudMessageId(long groudMessageId) {
		this.groudMessageId = groudMessageId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getMessageAuthorId() {
		return messageAuthorId;
	}
	public void setMessageAuthorId(long messageAuthorId) {
		this.messageAuthorId = messageAuthorId;
	}
	public String getMessageAuthor() {
		return messageAuthor;
	}
	public void setMessageAuthor(String messageAuthor) {
		this.messageAuthor = messageAuthor;
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
	public ChatMessage.Status getStatus() {
		return status;
	}
	public void setStatus(ChatMessage.Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "GroupChatMessage [groudMessageId=" + groudMessageId + ", groupId=" + groupId + ", messageAuthorId="
				+ messageAuthorId + ", messageAuthor=" + messageAuthor + ", messageContent=" + messageContent
				+ ", sentAt=" + sentAt + ", status=" + status + "]";
	}
    
}
