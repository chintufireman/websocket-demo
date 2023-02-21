package com.chatroom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker
public class Config implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //Send and receive function
        registry.enableSimpleBroker("/topic"); //on this url our broker will be enable
        registry.setApplicationDestinationPrefixes("/app"); //this will set prefix url so that whenever u want to hit any url use this first in url
        
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
      registry.addEndpoint("/server1").withSockJS(); //->to connect with server
      //if client want to send message then he have to connect with server so we wrote above line 
      //so that client can connect to server with the help of above url 
      
    }
    
}
