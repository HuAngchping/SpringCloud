package org.cloud.service.cloudservice3;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author huang
 * @create 2019-01-25
 */
@Data
@Document(collection = "mongo_test")
public class MongoTestEntity {

  @Id
  private String id;

  private String content;
}
