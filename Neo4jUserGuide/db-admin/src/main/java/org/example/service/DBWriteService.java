/**
 * Neo4jUserGuide
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/12/17
 **/
package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DBWriteService {

    @Value("${biz.neo4j-user-guide.topic}")
    private String topic;

    @KafkaListener(topics = "neo4j-user-guide-topic", groupId = "neo4j-user-guide")
    public void consume(String message) {
        log.info("收到：{}", message);
    }
}
