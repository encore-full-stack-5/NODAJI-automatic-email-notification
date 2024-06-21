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
    private int name;   //유저 네임

    @Column(name = "USER_RANK")
    private int rank;   //당첨된 순위

    @Column(name = "USER_EMAIL")
    private String email;   //유저 이메일

    @Column(name="USER_GAME")
    private String game;  //  유저가 참여한 게임


    public User ToEntity(String email,String id, long point, int name, int rank, String game) {

        new User();

        return User.builder()
                .email(email)
                .id(id)
                .point(point)
                .name(name)
                .rank(rank)
                .game(game)
                .build();
    }
}
