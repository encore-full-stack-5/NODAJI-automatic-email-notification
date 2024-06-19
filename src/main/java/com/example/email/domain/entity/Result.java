package com.example.email.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name ="RESULT")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="RESULT_ID")
    private Long id;


    @Column(name = "RESULT_FROM", nullable = true)
    private String from;    //보낸 사람의 이메일 주소


    @Column(name = "RESULT_TO", nullable = true)
    private String to;    //수신자 이메일 주소의 배열


    @Column(name = "RESULT_SENT_DATE", nullable = true)
    private Date sentDate;  //이메일 전송 시간


    @Column(name = "RESULT_SUBJECT", nullable = true)
    private String subject; //이메일 제목


    @Column(name = "RESULT_TEXT", nullable = true)
    private String text;    //이메일 내용


    @Column(name = "RESULT_STATUS", nullable = true)
    private Boolean status; //이메일 발송 여부 확인

    public Result ToEntity(Long id, String from, String to, Date sentDate, String subject, String text, Boolean status) {
        new Result();

        return Result.builder()
                .to(to)
                .from(from)
                .sentDate(sentDate)
                .subject(subject)
                .text(text)
                .status(status)
                .build();
    }
}
