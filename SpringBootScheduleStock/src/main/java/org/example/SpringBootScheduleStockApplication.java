package org.example;


import ch.qos.logback.core.util.FileUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableScheduling
public class SpringBootScheduleStockApplication {


    private RestTemplate request;
    @Value("${biz.url}")
    private String url;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootScheduleStockApplication.class, args);
    }

    @Scheduled(cron = "*/6 * * * * ?")
    public void sayHello() throws IOException {
        // ResponseEntity<String> response = request.getForEntity(url, String.class);
        HttpHeaders headers = new HttpHeaders();
        // headers.set("Cookie", "v=A0a1eWfSX2a7dgsyxX6hZOW3lzfNp7ibXPO-QzBtMGVGCejpmDfacSx7DjoD");
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = request.exchange(url, HttpMethod.GET, entity, String.class);
        File file = new File("./index.html");
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file));
        outputStream.write(response.getBody().getBytes());
        System.out.println(response.getBody());
    }

    @Autowired
    public void setRequest(RestTemplate request) {
        this.request = request;
    }
}