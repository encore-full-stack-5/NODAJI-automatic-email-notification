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


    @KafkaListener(topics ="user-topic")
    public void synchronization(KafkaStatus<KafkaUserDto> status) {
        switch (status.status()) {

            case "update" -> {
                User user = User.builder()
                        .id(status.data().id())
                        .name(status.data().name())
                        .email(status.data().email())
                        .point(status.data().point())
                        .build();

                userRepository.save(user);

                }
            case "delete" -> {

                User user = User.builder()
                        .id(status.data().id())
                        .build();

                userRepository.delete(user);
            }
            }





        }
}
