package com.budgetducklingsinc.websocketsinlamningsuppgift.ws;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.service.ChannelService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChatRoomSocketHandler extends TextWebSocketHandler {

    private List<WebSocketSession> webSocketSessions = new ArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for (WebSocketSession webSocketSession : webSocketSessions) {
            webSocketSession.sendMessage(new TextMessage(message.getPayload()));

            String messageToSend = session.getHandshakeHeaders().getFirst("id");
            broadcast(messageToSend);
        }
    }
    public void broadcast(String messageToSend) throws IOException {
        Gson gson = new Gson();

        for (WebSocketSession webSocketSession: webSocketSessions) {
            String textMessage = gson.toJson(messageToSend);
            webSocketSession.sendMessage(new TextMessage(textMessage));

        }
    }



    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws IOException {
        webSocketSessions.add(session);

    }



    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        webSocketSessions.remove(session);
    }
}