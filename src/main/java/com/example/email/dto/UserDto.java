package com.example.email.dto;

public record UserDto(
        String[] email,
        String id,
        int rank,
        String name,
        String game,
        Long point
) {
}
