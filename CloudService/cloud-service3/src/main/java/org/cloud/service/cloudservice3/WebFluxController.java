package org.cloud.service.cloudservice3;

import java.util.function.IntPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

/**
 * @author huang
 * @create 2019-02-22
 */
@RestController
public class WebFluxController {

  @Autowired
  WebFluxService webFluxService;

  @PostMapping("/webflux")
  public Mono<String> saveWebflux(@RequestParam("file")MultipartFile file) {
    long s = System.currentTimeMillis();
    Mono<String> mono = null;
    try {
      mono = webFluxService.save4Webflux(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
    long e = System.currentTimeMillis();
    System.out.println(e - s);
    return mono;
  }

  @PostMapping("/normal")
  public String saveNormal(@RequestParam("file")MultipartFile file) {
    long s = System.currentTimeMillis();
    String mono = null;
    try {
      mono = webFluxService.save4Normal(file);
    } catch (Exception e) {
      e.printStackTrace();
    }
    long e = System.currentTimeMillis();
    System.out.println(e - s);
    return mono;
  }

  @GetMapping("/hi")
  public Mono<String> sayHi() {
    return Mono.just("Hi!");
  }

}
