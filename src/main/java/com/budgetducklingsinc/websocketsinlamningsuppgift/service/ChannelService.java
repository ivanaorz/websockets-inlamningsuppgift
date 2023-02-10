package com.budgetducklingsinc.websocketsinlamningsuppgift.service;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.model.PermanentChannel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ChannelService {

    private static List<PermanentChannel> permanentChannels = new ArrayList<>();

    static {
        ChatRoom chatRoom = new ChatRoom(long id, String title);

        List<ChatRoom> chatRooms = new ArrayList<>(Arrays.asList(new ChatRoom(long id, String title)));

        PermanentChannel permanentChannel = new PermanentChannel(1, "Permanent Channel",chatRooms);

        permanentChannels.add(permanentChannel);

    }

    public PermanentChannel getPermanentChannelById(String permanentChannelId) {
    }

    public List<ChatRoom> getAllChatRooms(String permanentChannelId) {
    }

    public ChatRoom getChatRoomByTitle(String permanentChannelId, String chatRoomTitle) {
    }

    public ChatRoom getChatRoomById(String permanentChannelId, String chatRoomId) {
    }

    public String createChatRoom(String permanentChannelId, ChatRoom chatRoom) {
    }

    public void deleteChatRoom(String permanentChannelId, String chatRoomId) {
    }


//    public Object getChannelByTitle(String title) {
//    }
//
//    public Object getChannelById(long id) {
//    }
//
//    public String deleteChatRoom(String chatRoomId) {
//        List<chatRoom> chatRooms = getAllChatRooms();
//        if(chatRooms == null)
//            return null;
//        Predicate<? super ChatRoom> predicate = c -> c.getId().equalsIgnoreCase(chatRoom);
//        boolean removed = chatRooms.removeIf(predicate);
//        if(!removed) return null;
//        return chatRoomId;
//
//    }
//
//    public List<PermanentChannel> getAllChatRooms() {
//    }
//    
//    public void createChatRoom(String permanentChannelId, ChatRoom chatRoom) {
//    }
}
