package com.example.email.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
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

    @Column(name = "EMAIL_FROM", nullable = true)
    private String from;    //보낸 사람의 이메일 주소

    @Column(name = "EMAIL_REPLY_TO", nullable = true)
    private String replyTo; //답장을 보낼 이메일 주소

    @Column(name = "EMAIL_TO", nullable = true)
    private String[] to;    //수신자 이메일 주소의 배열

    @Column(name = "EMAIL_CC", nullable = true)
    private String[] cc;    //참조' 수신자로 포함될 이메일 주소 배열

    @Column(name = "EMAIL_BCC", nullable = true)
    private String[] bcc;   //'숨은 참조' 수신자로 포함될 이메일 주소 배열

    @Column(name = "EMAIL_SENT_DATE", nullable = true)
    private Date sentDate;  //이메일이 전송된 날짜

    @Column(name = "EMAIL_SUBJECT", nullable = true)
    private String subject; //이메일의 제목

    @Column(name = "EMAIL_TEXT", nullable = true)
    private String text;    //이메일의 본문 텍스트

    @Setter
    @Column(name = "EMAIL_STATUS", nullable = true)
    private Boolean status; //이메일 발송 여부 확인

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}
