package com.example.email.dto;

public record UserDto(
        String id,
        int rank,
        String game,
        Long point
) {
}
