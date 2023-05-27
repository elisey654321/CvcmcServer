package ru.cvcmc.CvcmcServer.chat;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import ru.cvcmc.CvcmcServer.entity.Chat;
import ru.cvcmc.CvcmcServer.entity.HttpRequest;

public class ChatTested {

    @Test
    public void testCreateChat() throws Exception {
        final RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Chat> stringHttpEntity = new HttpEntity<>(Chat.builder().name("test").build());
        String answerStr = restTemplate.postForObject("http://localhost:8043/chat/list",stringHttpEntity,String.class);
        HttpRequest answer = restTemplate.getForObject("http://localhost:8043/chat/list", HttpRequest.class);
        System.out.println(answer);
        System.out.println(answerStr);
    }

}
