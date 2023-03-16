package com.budgetducklingsinc.websocketsinlamningsuppgift.ws;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Exception;

public class ChatRoomSocketHandler extends TextWebSocketHandler {

    private final List<WebSocketSession> webSocketSessions = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String messageContent = message.getPayload();
        broadcast(messageContent);

        }

    public void broadcast(String messageContent) throws IOException {
        TextMessage messageToSend = new TextMessage(messageContent);

        for (WebSocketSession webSocketSession: webSocketSessions) {

            if (webSocketSession.isOpen())
              webSocketSession.sendMessage(messageToSend);

        }
    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            webSocketSessions.add(session);
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        webSocketSessions.remove(session);
    }
}