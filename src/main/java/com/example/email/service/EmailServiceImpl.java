package com.example.email.service;

import com.example.email.domain.entity.Certification;
import com.example.email.domain.entity.Email;
import com.example.email.domain.entity.Result;
import com.example.email.domain.repository.CertificationRepository;
import com.example.email.domain.repository.EmailRepository;
import com.example.email.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.UUID;




@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;
    private final CertificationRepository certificationRepository;


    @Override
    public String certificationEmail(EmailDto emailDto) {

        UUID certificationString = UUID.randomUUID(); //UUID 랜덤 생성으로 랜덤 인증값 생성
        //이후 redis 데이터 베이스로 유효시간 설정 예정
        String sendEmail = WelcomeMessage.makeContents(String.valueOf(certificationString)); //노다지 이메일 규경의 맞춰 이메일 내용 생성
        String subject = EmailEnum.WELCOME.getTitle();
        Email email = Email.builder()
                .subject(subject)       //이메일 제목
                .to(emailDto.to())      //받는이 이메일 주소
                .text(sendEmail)        //이메일 내용
                .build();
        javaMailSender.send(email);     //이메일 발송
        Certification certification = Certification.builder()
                .from("thtjdalstest@gmail.com")
                .subject(subject)       //이메일 제목
                .text(sendEmail)        //이메일 내용
                .status(true)           //이메일 상태(수신여부 확인예정)
                .sentDate(new Date())   //이메일 생성 시간
                .to(Arrays.toString(emailDto.to()))      //받는이 이메일 주소
                .build();
        certificationRepository.save(certification);//발송한 인증메일 객체 저장

        return sendEmail;
    }

    @Override
    public String winningEmail(UserDto userDto) {
        String sendEmail = WinningMessage.makeContents(userDto.name(),userDto.game(),userDto.rank()); //노다지 이메일 규경의 맞춰 이메일 내용 생성
        String subject = EmailEnum.CONGRATULATIONS.getTitle();
        Email email = Email.builder()
                .subject(subject)       //이메일 제목
                .to(userDto.email())   //받는이 이메일 주소
                .text(sendEmail)        //이메일 내용
                .from("thtjdalstest@gmail.com") //이메일 발송 계정
                .build();
        javaMailSender.send(email);     //이메일 발송

        Result result = Result.builder()
                .subject(subject)       //이메일 제목
                .to(Arrays.toString(userDto.email()))    //받는이 이메일 주소
                .text(sendEmail)        //이메일 내용
                .sentDate(new Date())   //이메일 생성 시간
                .status(true)           //이메일 상태(수신여부 확인예정)
                .from("thtjdalstest@gmail.com") //이메일 발송 계정
                .build();
        emailRepository.save(email);    //발송한 이메일 저장

        return sendEmail;
    }




}
