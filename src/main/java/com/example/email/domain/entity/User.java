package com.example.email.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="USER")
public class User {

    @Id
    @Column(name="USER_ID", nullable = false, unique = true)
    private String id;

    @Setter
    @Column(name="USER_POINT")
    private long point;

    @Column(name = "USER_RANK")
    private int rank;

    @Column(name="USER_GAME")
    private String game;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Email> emails;
}
