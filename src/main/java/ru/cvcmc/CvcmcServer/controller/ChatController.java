package ru.cvcmc.CvcmcServer.controller;

import org.apache.coyote.Response;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Response processValidationError(@NotNull MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        FieldError error = result.getFieldError();
        return new Response();
    }

//    private ErrorResponse processFieldError(FieldError error) {
//        ErrorResponse errorResponse = new ErrorResponse();
//        if (error != null) {
//            Locale currentLocale = LocaleContextHolder.getLocale();
//            String msg = messageSource.getMessage(error.getDefaultMessage(), null, currentLocale);
//            errorResponse.setMessage(msg);
//        }
//        return errorResponse;
//    }

    @GetMapping("/list/{id}")
    public HttpRequest getChatList(@RequestPart String id){
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
    public HttpRequest addChat(@RequestBody(required = false) Chat chat){
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
