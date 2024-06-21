package com.example.email.service;

import com.example.email.dto.EmailDto;
import com.example.email.dto.UserDto;
import com.example.email.kafka.dto.KafkaStatus;
import com.example.email.kafka.dto.KafkaUserDto;

public interface EmailService {

    String certificationEmail(EmailDto emailDto);

    String winningEmail(UserDto userDto);





}
