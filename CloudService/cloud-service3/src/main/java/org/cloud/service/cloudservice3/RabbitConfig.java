package org.cloud.service.cloudservice3;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * @author huang
 * @create 2019-01-21
 */
@Configuration
public class RabbitConfig {

  @Autowired
  AmqpAdmin amqpAdmin;

  @Autowired
  KafkaAdmin kafkaAdmin;

//  @Bean
//  public String[] queueNames() {
//    String[] names = new String[100000];
//    for (int i = 0; i < 100000; i++) {
//      String queueName = "queue" + i;
//      names[i] = queueName;
//    }
//    return names;
//  }
//
//  @Bean
//  public String[] queues() {
//    String[] names = queueNames();
//    for (int i = 0; i < names.length; i++) {
//      Queue queue = new Queue(names[i]);
//      amqpAdmin.declareQueue(queue);
//    }
//    return names;
//  }
  @Bean
  public Queue queue() {
    return new Queue("queue");
  }


}
