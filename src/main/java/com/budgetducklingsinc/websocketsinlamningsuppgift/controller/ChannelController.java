package com.budgetducklingsinc.websocketsinlamningsuppgift.controller;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.service.ChannelService;
import com.budgetducklingsinc.websocketsinlamningsuppgift.ws.ChatRoomSocketHandler;
import com.budgetducklingsinc.websocketsinlamningsuppgift.ws.PermanentChannelSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("permanentChannels")
public class ChannelController {

    @Autowired
    private ChannelService channelService;


    @GetMapping
    public ResponseEntity<List<ChatRoom>> getAllChatRooms() {
        List<ChatRoom> chatRooms = channelService.getAllChatRooms();
        if (chatRooms == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return ResponseEntity.status(HttpStatus.OK).body(chatRooms);
    }


//    @GetMapping("/chatRooms/{title}")
//    public ResponseEntity<ChatRoom> getChatRoomByTitle(@PathVariable String title) {
//        ChatRoom chatRoom = channelService.getChatRoomBy(title);
//        if (chatRoom == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(HttpStatus.OK).body(chatRoom);
//    }


//    @GetMapping("/chatRooms/{id}")
//    public ResponseEntity<ChatRoom> getChatRoomById(@PathVariable Long id) {
//        ChatRoom chatRoom = channelService.getChatRoomById(id);
//        if (chatRoom == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return ResponseEntity.status(HttpStatus.OK).body(chatRoom);
//    }



    @PostMapping("/chatRooms")
    public ResponseEntity createChatRoom(@RequestBody ChatRoom chatRoom) {
        ChatRoom persistedChatRoom = channelService.createChatRoom(chatRoom);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").build(persistedChatRoom.getId());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(persistedChatRoom);

    }



    @DeleteMapping("/chatRooms/{id}")
    public ResponseEntity<Void> deleteChatRoom(@PathVariable ("id") Long id) {
        channelService.deleteChatRoom(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}






