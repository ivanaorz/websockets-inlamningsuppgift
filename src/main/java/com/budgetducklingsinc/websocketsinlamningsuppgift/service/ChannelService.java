package com.budgetducklingsinc.websocketsinlamningsuppgift.service;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

//    private static List<PermanentChannel> permanentChannels = new ArrayList<>();
//
//    static {
//        ChatRoom chatRoom1 = new ChatRoom(long id, String title);

//        ChatRoom chatRoom1 = new ChatRoom(1, "Chat room 1. Fashion");
//
//        ChatRoom chatRoom2 = new ChatRoom(2, "Chat room 2. Cars");
//
//        ChatRoom chatRoom3 = new ChatRoom(1, "Chat room 3. Art");

//        List<ChatRoom> chatRooms = new ArrayList<>(Arrays.asList(new ChatRoom()));

//        List<ChatRoom> chatRooms = new ArrayList<>(Arrays.asList(chatRoom1, chatRoom2, chatRoom3));
//
//        PermanentChannel permanentChannel = new PermanentChannel(1, "Permanent Channel",chatRooms);
//
//        permanentChannels.add(permanentChannel);

//    }

//    public PermanentChannel getPermanentChannelById(String permanentChannelId) {
//        return jpaChannelRepository.getPermanentChannelById(permanentChannelId);
//    }



//    public PermanentChannel getPermanentChannelById(String permanentChannelId) {
//        Predicate<? super PermanentChannel> predicate = permanentChannel -> permanentChannel.getId().equalsIgnoreCase(permanentChannelId);
//
//        Optional<PermanentChannel> optionalPermanentChannel = permanentChannels.stream().filter(predicate).findFirst();
//
//        if(optionalPermanentChannel.isEmpty()) return null;
//        return optionalPermanentChannel.get();
//    }


    public List<ChatRoom> getAllChatRooms() {

        return channelRepository.findAll();
    }


//    public List<ChatRoom> getAllChatRooms(String permanentChannelId) {
//        PermanentChannel permanentChannel = getPermanentChannelById(permanentChannelId);
//        if(permanentChannel == null) return null;
//        return permanentChannel.getChatRooms();
//    }


    public ChatRoom getChatRoomBy(String chatRoomTitle) {
        return channelRepository.findChatRoomByTitle(chatRoomTitle);
    }

//    public ChatRoom getChatRoomByTitle(String permanentChannelId, String chatRoomTitle) {
//        List<ChatRoom> permanentChannelChatRooms = getAllChatRooms(permanentChannelId);
//        if(permanentChannelChatRooms == null) return null;
//        Optional<ChatRoom> optionalChatRoom = permanentChannelChatRooms.stream().
//                filter(c -> c.getId().equalsIgnoreCase(chatRoomTitle)).findFirst();
//        if(optionalChatRoom.isEmpty()) return null;
//        return optionalChatRoom.get();
//    }


    public ChatRoom getChatRoomById(String chatRoomId) {
        return channelRepository.findChatRoomById(chatRoomId);
    }
//    public ChatRoom getChatRoomById(String permanentChannelId, String chatRoomId) {
//        List<ChatRoom> permanentChannelChatRooms = getAllChatRooms(permanentChannelId);
//        if (permanentChannelChatRooms == null) return null;
//        Optional<ChatRoom> optionalChatRoom = permanentChannelChatRooms.stream().
//                filter(c -> c.getId().equalsIgnoreCase(chatRoomId)).findFirst();
//        if (optionalChatRoom.isEmpty()) return null;
//        return optionalChatRoom.get();
//    }


    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return channelRepository.save(chatRoom);
    }

//    public String createChatRoom(String permanentChannelId, ChatRoom chatRoom) {
//        List<ChatRoom> chatRooms = getAllChatRooms(permanentChannelId);
//        chatRoom.setId(generateRandomId());
//        chatRooms.add(chatRoom);
//        return chatRoom.getId();
//    }


//    private Long generateRandomId() {
//        SecureRandom secureRandom = new SecureRandom();
//        Long randomId = new BigInteger(32, secureRandom.toString());
//        return randomId;
//
//    }

    public void deleteChatRoom(String chatRoomId) {
        channelRepository.removeById(chatRoomId);
    }

//    public String deleteChatRoom(String permanentChannelId, String chatRoomId) {
//        List<ChatRoom> permanentChannelChatRooms = getAllChatRooms(permanentChannelId);
//        if(permanentChannelChatRooms == null)
//            return null;
//        Predicate<? super ChatRoom> predicate = c -> c.getId().equalsIgnoreCase(chatRoomId);
//        boolean removed = permanentChannelChatRooms.removeIf(predicate);
//        if(!removed) return null;
//        return chatRoomId;
//    }



//
//    public String deleteChatRoom(String chatRoomId) {
//        List<chatRoom> chatRooms = getAllChatRooms();
//        if(chatRooms == null)
//            return null;
//        Predicate<? super ChatRoom> predicate = c -> c.getId().equalsIgnoreCase(chatRoomId);
//        boolean removed = chatRooms.removeIf(predicate);
//        if(!removed) return null;
//        return chatRoomId;
//
//    }

}
