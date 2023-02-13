package com.budgetducklingsinc.websocketsinlamningsuppgift.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class ChatRoom {


    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // AUTO_INCREMENT
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

//    private String permanentChannel;
}
