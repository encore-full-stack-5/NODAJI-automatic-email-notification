package com.example.email.service;

import com.example.email.domain.entity.User;
import com.example.email.domain.repository.UserRepository;
import com.example.email.kafka.dto.KafkaStatus;
import com.example.email.kafka.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @KafkaListener(topics = "email-topic")
    public void synchronization(KafkaStatus<KafkaUserDto> status) {
        switch (status.status()) {
            case "delete" -> {

                User user = User.builder()
                        .id(status.data().id())
                        .game(status.data().game())
                        .point(status.data().point())
                        .rank(status.data().rank())
                        .build();

                userRepository.delete(user);
            }
            case "update" -> {

                User user = User.builder()
                        .id(status.data().id())
                        .game(status.data().game())
                        .point(status.data().point())
                        .rank(status.data().rank())
                        .build();

                userRepository.save(user);

                }
            }

        }
}
