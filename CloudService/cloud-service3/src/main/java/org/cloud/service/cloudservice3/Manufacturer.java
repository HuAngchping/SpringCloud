package org.cloud.service.cloudservice3;

import java.util.Date;
import lombok.Data;

/**
 * @author huang
 * @create 2019-01-25
 */
@Data
public class Manufacturer {

  /**
   * 主键
   */
  private String id;

  /**
   * 厂商名称
   */
  private String name;

  /**
   * 厂商编号
   */
  private String code;

  private String appKey;

  private String secretKey;

  /**
   * 生效日期
   */
  private Date effectiveDate;

  /**
   * 失效日期
   */
  private Date expiryDate;

  /**
   * 更新时间
   */
  private Date updateAt;

  /**
   * 创建时间
   */
  private Date createAt;

}
