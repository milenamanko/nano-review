package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.ChatMessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import com.udacity.jwdnd.c1.review.model.User;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final ChatMessageMapper chatMessageMapper;

    public MessageService(ChatMessageMapper chatMessageMapper) {
        this.chatMessageMapper = chatMessageMapper;
    }

    public int insertMessage(ChatMessage chatMessage) {
        return chatMessageMapper.insertMessage(new ChatMessage(null, chatMessage.getUsername(), chatMessage.getMessage()));
    }

    public ChatMessage getMessages() {
        return chatMessageMapper.getMessages();
    }
}