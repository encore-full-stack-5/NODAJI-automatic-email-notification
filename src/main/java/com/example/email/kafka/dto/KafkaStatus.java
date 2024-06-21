package com.example.email.kafka.dto;

public record KafkaStatus<T>(
        T data, String status
) {
}
