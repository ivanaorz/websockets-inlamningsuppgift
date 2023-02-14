package com.budgetducklingsinc.websocketsinlamningsuppgift.repository;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChannelRepository extends JpaRepository<ChatRoom, Long> {



      List<ChatRoom> findAll();

      ChatRoom findChatRoomByTitle(String chatRoomTitle);

      ChatRoom findChatRoomById(String chatRoomId);

      ChatRoom save(ChatRoom chatRoom);

      void removeById(String chatRoomId);


}
