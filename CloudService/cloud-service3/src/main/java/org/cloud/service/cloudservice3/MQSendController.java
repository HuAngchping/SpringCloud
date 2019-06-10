package org.cloud.service.cloudservice3;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Properties;
import lombok.extern.java.Log;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang
 * @create 2019-01-21
 */
@Log
@RestController
public class MQSendController {

  @Autowired
  AsyncTask asyncTask;

  @Autowired
  WebFluxService webFluxService;

  @Autowired
  KafkaTemplate<String, String> kafkaTemplate;

  @Autowired
  AmqpAdmin amqpAdmin;

  @Autowired
  AmqpTemplate amqpTemplate;

  @GetMapping("/kafka/send")
  public void kafkaSend() {
    kafkaTemplate.send("kafka_queue", "test");
  }

  @GetMapping("/test")
  public void send() {
    while (true) {
      amqpTemplate.convertAndSend("queue", "queue");
    }
  }

  @PostMapping("/send")
  public Object send(@RequestBody DeviceInfo info) throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    String str = objectMapper.writeValueAsString(info);
    log.info(str);
    amqpTemplate.convertAndSend("queue", str);
    return info;
  }

  @GetMapping("/queue")
  public Object queue() {
    Properties properties = amqpAdmin.getQueueProperties("queue");
    System.out.println(properties.getProperty("QUEUE_MESSAGE_COUNT"));
    System.out.println(properties.getProperty("QUEUE_CONSUMER_COUNT"));
    System.out.println(properties.getProperty("QUEUE_NAME"));
    return properties.propertyNames();
  }

  @GetMapping("/create")
  public String createQueue() {
    for (int i = 0; i < 100000; i++) {
      Queue queue = new Queue("queue" + i);
      amqpAdmin.declareQueue(queue);
    }
    return "ok";
  }

  @GetMapping("/delete")
  public String deleteQueue() {
    for (int i = 0; i < 100000; i++) {
      amqpAdmin.deleteQueue("queue" + i);
    }
    return "ok";
  }

  @GetMapping("/async")
  public String getAsync(@RequestParam("key") String key) {
    String status = AsyncTask.statusMap.get(key);
    if (status == null) {
      asyncTask.getMessage(key);
      return "正在解析......";
    } else if (status.equals("ing")) {
      return "正在解析......";
    } else {
      return status;
    }
  }
}
