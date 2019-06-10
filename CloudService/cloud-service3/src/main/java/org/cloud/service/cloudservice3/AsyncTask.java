package org.cloud.service.cloudservice3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author huang
 * @create 2019-01-22
 */
@Log
@Component
public class AsyncTask {

  public static Map<String, String> statusMap = new ConcurrentHashMap<>();

  @Async
  public void getMessage(String key) {
    statusMap.put(key, "ing");
    boolean flag = true;
    int i = 0;
    try {
      while (flag) {
        log.info(Thread.currentThread().getName() + "----------异步：>" + i);
        Thread.sleep(3000);
        i ++;
        if (i == 10) {
          flag = false;
        }
      }
      statusMap.put(key, "ok");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}
