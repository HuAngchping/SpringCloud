package org.cloud.service.cloudservice3;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huang
 * @create 2019-01-25
 */
@Log
@RestController
public class MongoTestController {

  @Autowired
  MongoTestRepository mongoTestRepository;

  @GetMapping("/mongo/save")
  public String save() {
    MongoTestEntity mongoTestEntity = new MongoTestEntity();
    mongoTestEntity.setContent("test");
    MongoTestEntity entity = mongoTestRepository.save(mongoTestEntity);
    log.info(entity.getId());
    log.info(entity.getContent());
    return "ok";
  }
}
