package com.example.email.service;

import com.example.email.dto.EmailDto;
import com.example.email.dto.UserDto;

public interface EmailService {

    String welcomeEmail(EmailDto emailDto);

    String winningEmail(UserDto userDto);



}
