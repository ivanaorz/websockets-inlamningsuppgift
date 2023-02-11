package com.budgetducklingsinc.websocketsinlamningsuppgift.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class PermanentChannel {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO_INCREMENT
    private String id;

    private String title;

    private List<ChatRoom> chatRooms;

  


}
