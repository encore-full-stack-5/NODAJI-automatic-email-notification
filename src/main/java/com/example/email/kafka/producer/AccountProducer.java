package com.example.email.kafka.producer;

import com.example.email.kafka.dto.KafkaAccountDto;
import com.example.email.kafka.dto.KafkaStatus;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;


@RequiredArgsConstructor
public class AccountProducer {

    private final KafkaTemplate<String, KafkaStatus<KafkaAccountDto>> kafkaTemplate;
    String topic ="account-topic";

    @Bean
    private NewTopic newTopic(){
        return new NewTopic(topic, 1, (short) 1);
    }

    public void send(KafkaAccountDto kafkaAccountDto, String status){
        KafkaStatus<KafkaAccountDto> kafkaStatus = new KafkaStatus<>(kafkaAccountDto, status);
        kafkaTemplate.send(topic, kafkaStatus);
    }


}
