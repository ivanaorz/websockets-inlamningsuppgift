package com.budgetducklingsinc.websocketsinlamningsuppgift.ws;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

public class ChatRoomSocketHandler extends TextWebSocketHandler {

//    @Autowired
//    private ChannelService channelService;

    private List<WebSocketSession> webSocketSessions = new ArrayList<>();


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        for (WebSocketSession webSocketSession : webSocketSessions) {
            String establishedSession = session.getHandshakeHeaders().getFirst("id");
            if (establishedSession.equals(session.getId())) {
                String messageContent = message.getPayload();
                webSocketSession.sendMessage(new TextMessage(messageContent));
            }
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketSessions.add(session);
        ChatRoom newChatRoom = new ChatRoom();
        newChatRoom.setTitle(session.getHandshakeHeaders().getFirst("title"));
        newChatRoom.setId(Long.valueOf(session.getHandshakeHeaders().getFirst("id")));
        String messageContent = "New chat room created: " + newChatRoom;
        session.sendMessage(new TextMessage(messageContent));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        webSocketSessions.remove(session);
    }
}