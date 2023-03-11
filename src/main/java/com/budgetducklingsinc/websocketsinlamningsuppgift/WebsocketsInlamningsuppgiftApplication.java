package com.budgetducklingsinc.websocketsinlamningsuppgift;

import com.budgetducklingsinc.websocketsinlamningsuppgift.ws.ChatRoomSocketHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsocketsInlamningsuppgiftApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsocketsInlamningsuppgiftApplication.class, args);
    }

    @Bean
    public ChatRoomSocketHandler chatRoomSocketHandler() {
        return new ChatRoomSocketHandler();
    }
}
