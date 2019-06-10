package org.cloud.service.cloudservice1;

import org.springframework.stereotype.Component;

/**
 * @author huang
 * @create 2018-12-26
 */
@Component
public class Service2Hystrix implements Service2Client {

  @Override
  public String getService() {
    return "hystrix service";
  }
}
