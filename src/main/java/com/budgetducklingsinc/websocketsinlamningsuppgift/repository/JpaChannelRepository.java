package com.budgetducklingsinc.websocketsinlamningsuppgift.repository;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.model.PermanentChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaChannelRepository extends JpaRepository<PermanentChannel, Long> {

      PermanentChannel getPermanentChannelById(String permanentChannelId);

      List<ChatRoom> getAllChatRooms(String permanentChannelId);

      ChatRoom getChatRoomByTitle(String permanentChannelId, String chatRoomTitle);

      ChatRoom getChatRoomById(String permanentChannelId, String chatRoomId);

      ChatRoom createChatRoom(String permanentChannelId, ChatRoom chatRoom);

      void deleteChatRoom(String permanentChannelId, String chatRoomId);


}
