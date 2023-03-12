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



    public ChatRoom getChatRoomBy(String title) {
        return channelRepository.findChatRoomByTitle(title);
    }


    public ChatRoom getChatRoomById(Long id) {
        return channelRepository.findChatRoomById(id);
    }



    public ChatRoom createChatRoom(ChatRoom chatRoom) {
        return channelRepository.save(chatRoom);
    }


    public void deleteChatRoom(Long id) {
        channelRepository.removeById(id);
    }

}
