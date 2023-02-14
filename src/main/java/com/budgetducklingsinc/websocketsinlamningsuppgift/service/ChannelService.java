package com.budgetducklingsinc.websocketsinlamningsuppgift.service;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;


    public List<ChatRoom> getAllChatRooms() {

        return channelRepository.findAll();
    }



    public ChatRoom getChatRoomBy(String chatRoomTitle) {
        return channelRepository.findChatRoomByTitle(chatRoomTitle);
    }


    public ChatRoom getChatRoomById(String chatRoomId) {
        return channelRepository.findChatRoomById(chatRoomId);
    }



    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return channelRepository.save(chatRoom);
    }


    public void deleteChatRoom(String chatRoomId) {
        channelRepository.removeById(chatRoomId);
    }

}
