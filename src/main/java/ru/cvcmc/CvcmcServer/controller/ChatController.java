package ru.cvcmc.CvcmcServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.cvcmc.CvcmcServer.entity.Chat;
import ru.cvcmc.CvcmcServer.repository.ChatRepository;

import java.util.List;

@RestController
public class ChatController {

    @Autowired
    ChatRepository chatRepository;

    @GetMapping("/chat/list")
    public List<Chat> getChatList(){
        return chatRepository.findAll();
    }

    @PostMapping("/chat/list")
    public Chat addChat(@RequestBody Chat chat){
        return chatRepository.save(chat);
    }

}
