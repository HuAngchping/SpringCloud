package org.cloud.service.cloudservice1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huang
 * @create 2018-12-21
 */
@FeignClient(name = "cloud-service2", fallback = Service2Hystrix.class)
public interface Service2Client {

  @RequestMapping(value = "/service2/service", method = RequestMethod.GET)
  String getService();

}
