package org.cloud.service.cloudservice1;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang
 * @create 2018-12-21
 */
@RefreshScope
@RestController
@RequestMapping(value = "/service1")
public class ServiceController {

  @Value("${user.role}")
  private String val;

  @Value("${server.port}")
  private String port;

  @Autowired
  Service2Client service2Client;

  @HystrixCommand(fallbackMethod = "getDefault")
  @RequestMapping(value = "/service")
  public String getService1(@RequestParam("name") String name) {
    if (name.equals("default")) {
      return "Service 1 " + port;
    } else {
      throw new RuntimeException();
    }
  }

  @RequestMapping(value = "/service2")
  public String getService2() {
    return service2Client.getService();
  }

  @RequestMapping(value = "/config")
  public String getConfigVal() {
    return val;
  }

  private String getDefault(String name) {
    return "hystrix default " + name;
  }
}
