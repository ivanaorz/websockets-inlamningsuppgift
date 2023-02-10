package com.budgetducklingsinc.websocketsinlamningsuppgift.controller;

import com.budgetducklingsinc.websocketsinlamningsuppgift.model.PermanentChannel;
import com.budgetducklingsinc.websocketsinlamningsuppgift.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {

    @Autowired
    private ChannelService channelService;

    @GetMapping("/permanentChannels/{permanentChannelId}/chatRooms")
    public ResponseEntity<List<PermanentChannel>> getChannels() {
        List<PermanentChannel> channels = channelService.getAllChatRooms();

        if (channels.isEmpty()) {
            return ResponseEntity
                    .status(204)
                    .header("x-information", "No data was found in the database")
                    .build();
        } else {
            return ResponseEntity.ok(channels);
        }
    }

    @GetMapping("/permanentChannels/{permanentChannelId}/chatRooms/{chatRoomTitle}")
    public ResponseEntity<PermanentChannel> getChannel(@PathVariable String title) {
        return ResponseEntity.ok(channelService.getChannelByTitle(title));
    }

    @GetMapping("/permanentChannels/{permanentChannelId}/chatRooms/{chatRoomId}")
    public ResponseEntity<PermanentChannel> getChannel(@PathVariable("id") long id) {
        return ResponseEntity.ok(channelService.getChannelById(id));
    }

    @PostMapping("/permanentChannels/{permanentChannelId}/chatRooms")
    public ResponseEntity<List<PermanentChannel>> createChatRoom(@PathVariable String permanentChannelId, @RequestBody ChatRoom chatRoom) {
        channelService.createChatRoom(permanentChannelId, chatRoom);
        List<PermanentChannel> chatRooms = channelService.getAllChatRooms();
        return ResponseEntity.status(201).body(chatRooms);
    }

    @DeleteMapping("/permanentChannels/{permanentChannelId}/chatRooms/{chatRoomId}")
    public ResponseEntity<PermanentChannel> deleteChatRoom(@PathVariable String chatRoomId) {
        channelService.deleteChatRoom(chatRoomId);

        if (chatRoomId > chatRooms.size()) {
            return ResponseEntity
                    .status(400)
                    .header("x-error-msg", "Id is out of bounds, course does not exist with such id")
                    .build();
        }
        return ResponseEntity.noContent().build();
    }
}



