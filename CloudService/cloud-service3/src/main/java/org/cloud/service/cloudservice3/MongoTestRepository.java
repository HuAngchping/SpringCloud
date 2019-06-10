package org.cloud.service.cloudservice3;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author huang
 * @create 2019-01-25
 */
@Repository
public interface MongoTestRepository extends MongoRepository<MongoTestEntity, String> {

}
