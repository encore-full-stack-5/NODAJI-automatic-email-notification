package com.example.email.service;


import com.example.email.kafka.dto.KafkaUserDto;

public interface EmailService {

    String certificationEmail(KafkaUserDto data);

    String winningEmail(KafkaUserDto data);





}
