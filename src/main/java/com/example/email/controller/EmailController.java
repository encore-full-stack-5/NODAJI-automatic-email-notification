package com.example.email.controller;

import com.example.email.dto.EmailDto;
import com.example.email.dto.UserDto;
import com.example.email.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/email")
public class EmailController {

    private final EmailService emailService;

    @GetMapping("certification")
    public String sendCertificationEmail(@RequestBody EmailDto emailDto) {
        String check = emailService.certificationEmail(emailDto);
        return check;
    }

    @GetMapping("result")
    public String sendWinningEmail(@RequestBody UserDto userDto) {
        String check = emailService.winningEmail(userDto);
        return check;
    }

}
