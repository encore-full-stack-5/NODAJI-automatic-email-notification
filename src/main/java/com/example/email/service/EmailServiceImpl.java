package com.example.email.service;

import com.example.email.domain.entity.Email;

import com.example.email.domain.entity.User;
import com.example.email.domain.repository.EmailRepository;
import com.example.email.domain.repository.UserRepository;
import com.example.email.dto.*;
import com.example.email.kafka.dto.KafkaStatus;
import com.example.email.kafka.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static com.example.email.dto.EmailEnum.CONGRATULATIONS;
import static com.example.email.dto.EmailEnum.WELCOME;


@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{

    private final JavaMailSender javaMailSender;
    private final EmailRepository emailRepository;
    private final RedisService redisService;
    private final UserRepository userRepository;

    @Override
    public String certificationEmail(KafkaUserDto data) {

        String certificationString = String.valueOf(UUID.randomUUID()); //UUID 랜덤 생성으로 랜덤 인증값 생성
        redisService.save(data.email(),certificationString);    //redis 데이터베이스에 UUID 값을 저장 1분간 존재하도록 설정
        String sendEmail = WelcomeMessage.makeContents(String.valueOf(certificationString)); //노다지 이메일 규경의 맞춰 이메일 내용 생성
        String subject = WELCOME.getTitle();// enum 상수 이메일 제목
        Email email = Email.builder()
                .subject(subject)       //이메일 제목
                .address(data.email()) //mysql 배열 값 어려워 String 값으로 저장
                .to(new String[]{data.email()})   //받는이 이메일 주소
                .text(sendEmail)        //이메일 내용
                .sentDate(new Date())   //이메일 발송 시간
                .from("thtjdalstest@gmail.com")
                .build();
        javaMailSender.send(email);     //이메일 발송
        emailRepository.save(email);    //이메일 저장

        return sendEmail;
    }


    @Override
    public String winningEmail(KafkaUserDto data) {



        Optional<User> byId = userRepository.findById(data.id());//DB에 해당 유저가 있는지 검색
        String findEmail = byId.get().getEmail();//유저가 있을 경우 이메일주소 저장

        String sendEmail = WinningMessage.makeContents(data.name(),data.game(),data.rank()); //노다지 이메일 규경의 맞춰 이메일 내용 생성
        String subject = CONGRATULATIONS.getTitle();// enum 상수 이메일 제목
        Email email = Email.builder()
                .subject(subject)      //이메일 제목
                .address(findEmail)
                .to(new String[]{findEmail}) //받는이 이메일 주소
                .text(sendEmail)        //이메일 내용
                .sentDate(new Date())   //이메일 발송 시간
                .from("thtjdalstest@gmail.com") //이메일 발송 계정
                .build();
        javaMailSender.send(email);     //이메일 발송
        emailRepository.save(email);    //이메일 저장

        return sendEmail;
    }

    @KafkaListener(topics ="email-topic")
    public void synchronization(KafkaStatus<KafkaUserDto> status) {
        switch (status.status()) {
            case "result" -> {
                System.out.println(status.data().id());
                System.out.println(status.data().rank());
                System.out.println(status.data().point());
                System.out.println(status.data());
                winningEmail(status.data());
                }

            case "singUp" -> {
                certificationEmail(status.data());
            }


        }

    }


}




