package com.budgetducklingsinc.websocketsinlamningsuppgift.config;

import com.budgetducklingsinc.websocketsinlamningsuppgift.ws.ChannelSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class SocketConfiguration implements WebSocketConfigurer {

    @Autowired
    private ChannelSocketHandler channelSocketHandler;

    private final static String SOCKET_PREFIX = "/sub";
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(channelSocketHandler,SOCKET_PREFIX + "/student/state");

    }
}
