package com.kafka_sample.producer;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProducerController {

  private final ProducerService producerService;

  @GetMapping("/send")
  public String sendMessage(
          @RequestParam("topic")
          String topic,
          @RequestParam("key")
          String key,
          @RequestParam("message")
          String message
  ){
    producerService.sendMessage(topic,key,message);
      return "Message send to Kafka topic";
  }

}
