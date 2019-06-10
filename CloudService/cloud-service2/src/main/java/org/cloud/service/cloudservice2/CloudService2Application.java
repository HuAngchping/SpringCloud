package org.cloud.service.cloudservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
public class CloudService2Application {

  public static void main(String[] args) {
    SpringApplication.run(CloudService2Application.class, args);
  }

}

