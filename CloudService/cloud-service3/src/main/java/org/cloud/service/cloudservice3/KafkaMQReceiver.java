package org.cloud.service.cloudservice3;

import java.util.Optional;
import lombok.extern.java.Log;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author huang
 * @create 2019-01-24
 */
@Log
@Component
public class KafkaMQReceiver {

//  @KafkaListener(topics = {"kafka_queue"})
  public void receiver(ConsumerRecord<?, ?> record) {
    Optional<?> kafkaMessage = Optional.ofNullable(record.value());
    if (kafkaMessage.isPresent()) {
      Object message = kafkaMessage.get();
      log.info("record = " + record);
      log.info("message = " + message);
    }
  }

}
