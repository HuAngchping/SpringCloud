package org.cloud.service.cloudservice3;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author huang
 * @create 2019-01-21
 */
@Component
//@RabbitListener(queues = "queue")
public class MQReceiver {

  @RabbitHandler
  public void receiver(String msg) {
    System.out.println("Receiver: " + msg);
  }
}
