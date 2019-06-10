package org.cloud.service.cloudservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@RefreshScope
@EnableFeignClients
@SpringCloudApplication
public class CloudService1Application {

  public static void main(String[] args) {
    SpringApplication.run(CloudService1Application.class, args);
  }

}

