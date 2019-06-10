package org.cloud.service.cloudservice3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang
 * @create 2019-01-25
 */
@RestController
public class RedisTestController {

  @Autowired
  RedisTemplate redisTemplate;

  @GetMapping("/redis/save")
  public String save() {
    redisTemplate.opsForValue().set("my", "redis_test");
    return "ok";
  }

  @GetMapping("/redis/get")
  public String get() {
//    redisTemplate.opsForValue().append("my", "redis_test_append");
    return redisTemplate.opsForValue().get("my").toString();
  }

  @GetMapping("/redis/del")
  public void del() {
    redisTemplate.delete("my");
  }
}
