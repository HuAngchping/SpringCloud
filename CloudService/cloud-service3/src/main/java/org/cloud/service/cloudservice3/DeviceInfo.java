package org.cloud.service.cloudservice3;

import java.io.Serializable;
import lombok.Data;

/**
 * @author huang
 * @create 2019-01-22
 */
@Data
public class DeviceInfo implements Serializable {

  private String deviceId;

  private String deviceContent;

}
