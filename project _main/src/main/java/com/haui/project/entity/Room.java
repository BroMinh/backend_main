package com.haui.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ROOM")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID", nullable = false)
    private Long roomId;
    @Column(name = "ROOM_NAME", nullable = false,length = 45)
    private String roomName;
    @Column(name = "ROOM_CATEGORY",length = 45)
    private String roomCategory;
    @Column(name = "ROOM_PRICE")
    private double roomPrice;
    @Column(name = "ROOM_STATUS", length = 45)
    private String roomStatus;
    public  Room(Long roomId, String roomName){
        this.roomId = roomId;
        this.roomName = roomName;
    }
}
