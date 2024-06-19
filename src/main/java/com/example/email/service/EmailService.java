package com.example.email.service;

import com.example.email.dto.EmailDto;
import com.example.email.dto.UserDto;

public interface EmailService {

    String certificationEmail(EmailDto emailDto);

    String winningEmail(UserDto userDto);



}
