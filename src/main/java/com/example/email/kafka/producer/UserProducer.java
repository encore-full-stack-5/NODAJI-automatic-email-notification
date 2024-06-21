package com.example.email.kafka.producer;

import com.example.email.kafka.dto.KafkaStatus;
import com.example.email.kafka.dto.KafkaUserDto;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserProducer {
    private final KafkaTemplate<String, KafkaStatus<KafkaUserDto>> kafkaTemplate;
    String name ="email-topic";

    @Bean
    private NewTopic newTopic(){
        return new NewTopic(name, 1, (short) 1);
    }

    public void send(KafkaUserDto kafkaUserDto, String status){
        KafkaStatus<KafkaUserDto> kafkaStatus = new KafkaStatus<>(kafkaUserDto, status);
        kafkaTemplate.send(name, kafkaStatus);
    }

}
