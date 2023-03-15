package com.budgetducklingsinc.websocketsinlamningsuppgift.config;

import com.budgetducklingsinc.websocketsinlamningsuppgift.ws.ChatRoomSocketHandler;
import com.budgetducklingsinc.websocketsinlamningsuppgift.ws.PermanentChannelSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfiguration implements WebSocketConfigurer {


    @Autowired
    private PermanentChannelSocketHandler permanentChannelSocketHandler;

    @Autowired
    private ChatRoomSocketHandler chatRoomSocketHandler;


    private final static String SOCKET_PREFIX = "/sub";

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(permanentChannelSocketHandler, SOCKET_PREFIX +"/permanentChannels");
        registry.addHandler(chatRoomSocketHandler,SOCKET_PREFIX + "/chatRooms");
    }

}


