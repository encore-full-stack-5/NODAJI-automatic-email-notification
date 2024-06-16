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
    private Boolean status; //메일의 발송 미 발송 확인을 위한 컬럼

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;  //이메일 서비스 진행시 유저 아이디가 중복 저장 발생 예상되는 점으로 1대 다 관계 엔티티 생성
}
