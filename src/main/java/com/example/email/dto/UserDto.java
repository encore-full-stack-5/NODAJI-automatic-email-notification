package com.example.email.dto;

public record UserDto(
        String[] to,
        String email,
        String id,
        int rank,
        String name,
        String game,
        Long point,
        int round
) {
}
