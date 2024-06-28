package com.example.email.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name="USER")
public class User {

    @Id
    @Column(name="USER_ID", nullable = false, unique = true)
    private String id;

    @Setter
    @Column(name="USER_POINT")
    private long point; //노다지 플랫폼 포인트

    @Column(name = "USER_NAME")
    private String name;   //유저 네임


    @Column(name = "USER_EMAIL")
    private String email;   //유저 이메일



    public User ToEntity(String email,String id, long point, String name) {

        new User();

        return User.builder()
                .email(email)
                .id(id)
                .point(point)
                .name(name)
                .build();
    }
}
