package com.example.email.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name ="EMAIL")
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name ="EMAIL_ID")
    private UUID id;

    @Setter
    @Column(name = "EMAIL_STATUS")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}
