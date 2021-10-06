package com.udacity.jwdnd.c1.review.mapper;

import com.udacity.jwdnd.c1.review.model.ChatMessage;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

public interface ChatMessageMapper {

    @Select("SELECT * FROM MESSAGES")
    ChatMessage getMessages();

    @Insert("INSERT INTO MESSAGES(username, message) VALUES(#{username}, #{message})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
    int insertMessage(ChatMessage chatMessage);
}
