package com.budgetducklingsinc.websocketsinlamningsuppgift.controller;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.ChatRoom;
import com.budgetducklingsinc.websocketsinlamningsuppgift.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    private ChannelService channelService;

//    PermanentChannel permanentChannel = new PermanentChannel();

//    @GetMapping("/permanentChannels/{permanentChannelId}")
//    public PermanentChannel getPermanentChannelById (@PathVariable String permanentChannelId) {
//        PermanentChannel permanentChannel = channelService.getPermanentChannelById(permanentChannelId);
//        if(permanentChannel == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//            return permanentChannel;
//    }

    @GetMapping("/permanentChannels")
        public List<ChatRoom> getAllChatRooms() {
        List<ChatRoom> chatRooms = channelService.getAllChatRooms();
        if(chatRooms == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return chatRooms;
    }

//    @GetMapping("/permanentChannels/{permanentChannelId}/chatRooms")
//    public List<ChatRoom> getAllChatRooms(@PathVariable String permanentChannelId) {
//        List<ChatRoom> chatRooms = channelService.getAllChatRooms(permanentChannelId);
//        if(chatRooms == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return chatRooms;
//    }

//    @GetMapping("/permanentChannels/{permanentChannelId}/chatRooms")
//    public ResponseEntity<List<PermanentChannel>> getChannels() {
//        List<PermanentChannel> channels = channelService.getAllChatRooms();
//
//        if (channels.isEmpty()) {
//            return ResponseEntity
//                    .status(204)
//                    .header("x-information", "No data was found in the database")
//                    .build();
//        } else {
//            return ResponseEntity.ok(channels);
//        }
//    }

    @GetMapping("/permanentChannels/chatRooms/{chatRoomTitle}")
    public ChatRoom getChatRoomByTitle(@PathVariable String chatRoomTitle) {
        ChatRoom chatRoom = channelService.getChatRoomBy(chatRoomTitle);
        if(chatRoom == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return chatRoom;
    }

//    @GetMapping("/permanentChannels/{permanentChannelId}/chatRooms/{chatRoomTitle}")
//    public ChatRoom getChatRoomByTitle(@PathVariable String permanentChannelId,
//                                       @PathVariable String chatRoomTitle) {
//        ChatRoom chatRoom = channelService.getChatRoomByTitle(permanentChannelId, chatRoomTitle);
//        if(chatRoom == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return chatRoom;
//    }
    @GetMapping("/permanentChannels/chatRooms/{chatRoomId}")
    public ChatRoom getChatRoomById(@PathVariable String chatRoomId) {
        ChatRoom chatRoom = channelService.getChatRoomById(chatRoomId);
        if(chatRoom == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return chatRoom;
    }
//    @GetMapping("/permanentChannels/{permanentChannelId}/chatRooms/{chatRoomId}")
//    public ChatRoom getChatRoomById(@PathVariable String permanentChannelId,
//                                    @PathVariable String chatRoomId) {
//        ChatRoom chatRoom = channelService.getChatRoomById(permanentChannelId, chatRoomId);
//        if(chatRoom == null)
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//        return chatRoom;
//    }

    @PostMapping("/permanentChannels")
    public void createChatRoom(@RequestBody ChatRoom chatRoom) {
//        ChatRoom chatRoom = new ChatRoom(chatRoom);
        channelService.createChatRoom(chatRoom);



    }
//    @PostMapping("/permanentChannels/{permanentChannelId}/chatRooms")
//    public ResponseEntity<Object> createChatRoom(@PathVariable String permanentChannelId, @RequestBody ChatRoom chatRoom) {
//        String chatRoomId = String.valueOf(channelService.createChatRoom(permanentChannelId, chatRoom));
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/chatRoomId")
//                .buildAndExpand(chatRoomId).toUri();
//
//        return ResponseEntity.created(location).build();
//    }

//    @PostMapping("/permanentChannels/{permanentChannelId}/chatRooms")
//    public ResponseEntity<List<PermanentChannel>> createChatRoom(@PathVariable String permanentChannelId, @RequestBody ChatRoom chatRoom) {
//        channelService.createChatRoom(permanentChannelId, chatRoom);
//        List<PermanentChannel> chatRooms = channelService.getAllChatRooms();
//        return ResponseEntity.status(201).body(chatRooms);
//    }

    @DeleteMapping("/permanentChannels/chatRooms/{chatRoomId}")
    public void deleteChatRoom(@PathVariable String chatRoomId) {
        channelService.deleteChatRoom(chatRoomId);

//        if (chatRoomId > chatRooms.size()) {
//            return ResponseEntity
//                    .status(400)
//                    .header("x-error-msg", "Id is out of bounds, course does not exist with such id")
//                    .build();
//        }

    }

//    @DeleteMapping("/permanentChannels/{permanentChannelId}/chatRooms/{chatRoomId}")
//    public ResponseEntity<Object> deleteChatRoom(@PathVariable String permanentChannelId, @PathVariable String chatRoomId) {
//        channelService.deleteChatRoom(permanentChannelId, chatRoomId);
//
////        if (chatRoomId > chatRooms.size()) {
////            return ResponseEntity
////                    .status(400)
////                    .header("x-error-msg", "Id is out of bounds, course does not exist with such id")
////                    .build();
////        }
//        return ResponseEntity.noContent().build();
//    }
}



