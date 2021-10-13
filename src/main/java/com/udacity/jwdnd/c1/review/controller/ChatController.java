package com.udacity.jwdnd.c1.review.controller;

import com.udacity.jwdnd.c1.review.model.ChatForm;
import com.udacity.jwdnd.c1.review.service.AuthenticationService;
import com.udacity.jwdnd.c1.review.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private final MessageService messageService;
    private final AuthenticationService authenticationService;

    public ChatController(MessageService messageService, AuthenticationService authenticationService) {
        this.messageService = messageService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String getMessagesPage(@ModelAttribute("chatForm") ChatForm chatForm, Model model) {
        model.addAttribute("chatMessages", this.messageService.getMessages());

        return "chat";
    }

    @PostMapping
    public String postMessage(@ModelAttribute("chatForm") ChatForm chatForm, Authentication authentication, Model model) {
        chatForm.setUsername(currentUserName(authentication));
        this.messageService.insertMessage(chatForm);
        chatForm.setMessageText("");
        model.addAttribute("chatMessages", this.messageService.getMessages());

        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public String[] allMessageTypes() {
        return new String[]{"Say", "Shout", "Whisper"};
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}