package com.budgetducklingsinc.websocketsinlamningsuppgift.ws;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.service.ChannelService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PermanentChannelSocketHandler extends TextWebSocketHandler {

    @Autowired
    private ChannelService channelService;

    private List<WebSocketSession> webSocketSessions = new ArrayList<>();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for (WebSocketSession webSocketSession : webSocketSessions) {
            webSocketSession.sendMessage(new TextMessage(message.getPayload()));
        }
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketSessions.add(session);
        Gson gson = new Gson();
        for (ChatRoom chatRoom : channelService.getAllChatRooms()) {
            String messageContent = gson.toJson(chatRoom);
            session.sendMessage(new TextMessage(messageContent));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        webSocketSessions.remove(session);
    }
}