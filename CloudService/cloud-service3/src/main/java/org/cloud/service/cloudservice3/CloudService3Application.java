package org.cloud.service.cloudservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableAsync
@EnableWebFlux
@SpringBootApplication
public class CloudService3Application {

  public static void main(String[] args) {
    SpringApplication.run(CloudService3Application.class, args);
  }

}

