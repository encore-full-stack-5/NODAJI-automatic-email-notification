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
    private String from;

    @Column(name = "EMAIL_REPLY_TO", nullable = true)
    private String replyTo;

    @Column(name = "EMAIL_TO", nullable = true)
    private String[] to;

    @Column(name = "EMAIL_CC", nullable = true)
    private String[] cc;

    @Column(name = "EMAIL_BCC", nullable = true)
    private String[] bcc;

    @Column(name = "EMAIL_SENT_DATE", nullable = true)
    private Date sentDate;

    @Column(name = "EMAIL_SUBJECT", nullable = true)
    private String subject;

    @Column(name = "EMAIL_TEXT", nullable = true)
    private String text;

    @Setter
    @Column(name = "EMAIL_STATUS", nullable = true)
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
}
