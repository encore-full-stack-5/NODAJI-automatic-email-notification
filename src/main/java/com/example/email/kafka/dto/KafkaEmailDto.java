package com.example.email.kafka.dto;

import java.util.Date;

public record KafkaEmailDto(
        String email,
        String[] to,
        Date sentDate,
        String subject
) {


}
