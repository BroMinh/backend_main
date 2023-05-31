package com.haui.project.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERTB")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;
    @Column(name = "USER_NAME",nullable = false,length = 45)
    private String userName;
    @Column(name = "USER_IMAGE", length = 200)
    private String userImage;
    @Column(name = "USER_EMAIL", length = 45)
    private String userEmail;
    @Column(name = "USER_PASS",nullable = false,length = 45)
    private String userPass;
}
