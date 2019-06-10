package edu.spring.cloud.microservice.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class MicroserviceGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroserviceGatewayApplication.class, args);
  }

}

