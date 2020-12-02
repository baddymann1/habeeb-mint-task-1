package com.mint.task1.domain.kafka;

import com.mint.task1.domain.order.dto.OrderDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class KafkaProducerService {

    @Autowired
    private  KafkaTemplate<String, OrderDTO> kafkaTemplate;
    private final String TOPIC = "Kafka_Task1";

    public void publishOrder(OrderDTO orderDTO){
       kafkaTemplate.send(TOPIC, orderDTO);
    }
}
