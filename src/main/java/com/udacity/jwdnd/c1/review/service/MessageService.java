package com.udacity.jwdnd.c1.review.service;

import com.udacity.jwdnd.c1.review.mapper.ChatMessageMapper;
import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private final ChatMessageMapper chatMessageMapper;

    public MessageService(ChatMessageMapper chatMessageMapper) {
        this.chatMessageMapper = chatMessageMapper;
    }

    public void insertMessage(ChatForm chatForm) {
        ChatMessage newMessage = new ChatMessage();
        newMessage.setUsername(chatForm.getUsername());

        switch (chatForm.getMessageType()) {
            case "Say" -> newMessage.setMessage(chatForm.getMessageText());
            case "Whisper" -> newMessage.setMessage(chatForm.getMessageText().toLowerCase());
            case "Shout" -> newMessage.setMessage(chatForm.getMessageText().toUpperCase());
        }
         chatMessageMapper.insertMessage(newMessage);
    }

    public List<ChatMessage> getMessages() {
        return chatMessageMapper.getMessages();
    }
}