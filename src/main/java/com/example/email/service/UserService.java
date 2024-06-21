package com.example.email.service;

import com.example.email.dto.UserDto;
import com.example.email.kafka.dto.KafkaStatus;
import com.example.email.kafka.dto.KafkaUserDto;

public interface UserService {

    public void synchronization(KafkaStatus<KafkaUserDto> status);
}
