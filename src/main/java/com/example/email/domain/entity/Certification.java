package com.example.email.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name ="CERTIFICATION")
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="CERTIFICATION_ID")
    private Long id;


    @Column(name = "EMAIL_FROM", nullable = true)
    private String from;    //보낸 사람의 이메일 주소


    @Column(name = "CERTIFICATION_TO", nullable = true)
    private String to;    //수신자 이메일 주소의 배열


    @Column(name = "CERTIFICATION_SENT_DATE", nullable = true)
    private Date sentDate;  //이메일 전송 시간


    @Column(name = "CERTIFICATION_SUBJECT", nullable = true)
    private String subject; //이메일 제목


    @Column(name = "CERTIFICATION_TEXT", nullable = true)
    private String text;    //이메일 내용


    @Column(name = "EMAIL_STATUS", nullable = true)
    private Boolean status; //이메일 발송 여부 확인

    public Certification ToEntity(Long id, String from, String to, Date sentDate, String subject, String text, Boolean status) {

        new Certification();
        return  builder()
                .from(from)
                .sentDate(sentDate)
                .status(status)
                .subject(subject)
                .text(text)
                .to(to)
                .build();
    }
}
