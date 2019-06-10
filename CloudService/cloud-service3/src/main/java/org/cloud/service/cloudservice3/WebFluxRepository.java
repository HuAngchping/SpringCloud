package org.cloud.service.cloudservice3;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
 * @author huang
 * @create 2019-02-22
 */
public interface WebFluxRepository extends ReactiveMongoRepository<WebFluxEntity, String> {

  Mono<WebFluxEntity> findByWeb(String web);
}
