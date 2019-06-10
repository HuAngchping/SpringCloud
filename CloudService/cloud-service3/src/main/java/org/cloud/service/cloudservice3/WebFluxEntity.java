package org.cloud.service.cloudservice3;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @author huang
 * @create 2019-02-22
 */
@Data
@AllArgsConstructor
public class WebFluxEntity {

  @Id
  private String id;

  private String web;

  private String flux;

}
