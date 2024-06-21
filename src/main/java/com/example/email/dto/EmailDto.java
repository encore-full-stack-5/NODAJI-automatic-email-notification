package com.example.email.dto;

import java.util.Date;

public record EmailDto(
       String from,
       String replyTo,
       String email,
       String[] to,
       String[] cc,
       String[] bcc,
       Date sentDate,
       String subject,
       String text
) {
}
