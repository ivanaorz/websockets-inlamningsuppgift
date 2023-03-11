package com.budgetducklingsinc.websocketsinlamningsuppgift.model;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Table(name="chatRooms")
public class ChatRoom {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

}
