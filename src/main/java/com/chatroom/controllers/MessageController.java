package com.chatroom.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chatroom.models.Message;

@RestController
public class MessageController {

    
    @MessageMapping("/message") //user 1 will send message to this url
    @SendTo("/topic/return-to") //and the people who have subscribed this url will receive the message
    public Message getContent(@RequestBody Message message){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return message;
    }
}
