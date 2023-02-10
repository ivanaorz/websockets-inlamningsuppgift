package com.budgetducklingsinc.websocketsinlamningsuppgift.service;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.PermanentChannel;

import java.util.List;

public class ChannelService {




    public Object getChannelByTitle(String title) {
    }

    public Object getChannelById(long id) {
    }

    public String deleteChatRoom(String chatRoomId) {
        List<chatRoom> chatRooms = getAllChatRooms();
        if(chatRooms == null)
            return null;
        Predicate<? super ChatRoom> predicate = c -> c.getId().equalsIgnoreCase(chatRoom);
        boolean removed = chatRooms.removeIf(predicate);
        if(!removed) return null;
        return chatRoomId;

    }

    public List<PermanentChannel> getAllChatRooms() {
    }



    public void createChatRoom(String permanentChannelId, ChatRoom chatRoom) {
    }
}
