package org.cloud.service.cloudservice2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang
 * @create 2018-12-21
 */
@RestController
@RequestMapping(value = "/service2")
public class ServiceController {

  @Value("${user.role}")
  private String val;

  @RequestMapping(value = "/service")
  public String getService1() {
    return "Service 2";
  }

  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  public String hello(@RequestBody String value) {
    return value;
  }

  @RequestMapping(value = "/world")
  public String world(@RequestParam("world") String world) {
    return "hello " + world;
  }

  @RequestMapping(value = "/config")
  public String getVal() {
    return val;
  }
}
