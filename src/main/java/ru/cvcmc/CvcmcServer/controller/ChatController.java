package ru.cvcmc.CvcmcServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cvcmc.CvcmcServer.entity.Chat;
import ru.cvcmc.CvcmcServer.entity.HttpRequest;
import ru.cvcmc.CvcmcServer.repository.ChatRepository;
import ru.cvcmc.CvcmcServer.service.HttpRequestService;

import java.util.List;

@RestController
@RequestMapping(path = "/chat/")
public class ChatController {

    @Autowired
    ChatRepository chatRepository;

    @GetMapping("/list")
    public HttpRequest getChatList(){
        HttpRequest request;
        try {
            List<Chat> allChat = chatRepository.findAll();
            request = HttpRequestService.createHttpRequest(allChat, 200);
        }catch (Exception e){
            request = HttpRequestService.createHttpRequest(null, 300,e.getMessage());
        }
        return request;
    }

    @PostMapping("/list")
    public HttpRequest addChat(@RequestBody Chat chat){
        HttpRequest request;
        try {
            chatRepository.saveAndFlush(chat);
            request = HttpRequestService.createHttpRequest(chat, 200);
        }catch (Exception e){
            request = HttpRequestService.createHttpRequest(chat, 300,e.getMessage());
        }
        return request;
    }

}
