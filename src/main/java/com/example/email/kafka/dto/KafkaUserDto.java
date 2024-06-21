package com.example.email.kafka.dto;

public record KafkaUserDto(
        String id,
        long point,
        int name,
        int rank,
        String game
) {
}
