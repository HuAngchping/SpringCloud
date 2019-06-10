package org.cloud.service.cloudservice3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

/**
 * @author huang
 * @create 2019-02-22
 */
@Service
public class WebFluxService {

  public String save4Normal(MultipartFile file) throws Exception {
    String path = saveImage("flux", "web", file.getBytes());
    return path;
  }

  public Mono<String> save4Webflux(MultipartFile file) throws Exception {
//    Mono.create(saveImage("flux", "web", file.getBytes()))
//    return Mono.fromSupplier(() -> {
//      String path = "";
//      try {
//        path = saveImage("flux", "web", file.getBytes());
//      } catch (Exception e) {
//        e.printStackTrace();
//      }
//      return path;
//    });
    return Mono.fromCallable(() -> saveImage("flux", "web", file.getBytes()));
//    return Mono.just(saveImage("flux", "web", file.getBytes()));
  }

  public String saveImage(String appKey, String secretKey, byte[] imageData) {
    try {
      TimeUnit.SECONDS.sleep(5);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
//    String date = "20190222";
//    String path = "/Users/huang/temp" + "/" + secretKey + "/" + appKey + "/" + date;
//    Path isExist = Paths.get(path);
//    if (!Files.exists(isExist)) {
//      Files.createDirectories(isExist);
//    }
//    String fileName = System.currentTimeMillis() + ".png";
//    Path p = Paths.get(path + "/" + fileName);
//    Files.write(p, imageData);
    return appKey + "/" + secretKey;
  }


}
