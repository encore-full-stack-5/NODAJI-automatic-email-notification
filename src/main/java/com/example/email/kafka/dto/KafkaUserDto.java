package com.example.email.kafka.dto;

import java.util.List;

public record KafkaUserDto(
        String id,
        long point,
        String name,
        int rank,
        String game
) {

    public String[] converter(String email) {
        String[] emailArray = new String[1];
        emailArray[0] = email;
        return emailArray;
    }

    public String[] converter(List<String> emails) {
        return emails.toArray(new String[0]);
    }


}
