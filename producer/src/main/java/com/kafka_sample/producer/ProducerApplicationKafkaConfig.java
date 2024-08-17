package com.kafka_sample.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerApplicationKafkaConfig {
  @Bean
  public ProducerFactory<String, String> producerFactory() {
    Map<String, Object> configProps = new HashMap<>();
    // Kafka가 로컬 호스트의 9092 포트에서 실행되고 있다는 것을 의미
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    //KEY, VALUE 를 직렬화(Serializer) StringSerializer로 설정.
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean
  // Kafka에 메시지를 보내기 위해 KafkaTemplate 빈을 생성 / 위에서 정의한 producerFactory 메서드를 사용
  public KafkaTemplate<String, String> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}
