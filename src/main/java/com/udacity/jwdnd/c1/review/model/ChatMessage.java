package com.udacity.jwdnd.c1.review.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;

public class ChatMessage {

    private Integer messageId;

    private String username;

    private String message;

    public ChatMessage() {

    }

    public ChatMessage(Integer messageId, String username, String message) {
        this.messageId = messageId;
        this.username = username;
        this.message = message;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
