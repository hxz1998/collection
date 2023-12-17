/**
 * Neo4jUserGuide
 *
 * @Author: cherry
 * @Create on: 2023/11/19
 **/
package org.example;

import jakarta.websocket.server.PathParam;
import java.util.List;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Person;
import org.example.repository.PersonRelationshipRepository;
import org.example.repository.PersonRepository;
import org.example.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.neo4j.core.FluentFindOperation.ExecutableFind;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/neo4j/")
@Setter(onMethod_ = {@Autowired})
@Slf4j
public class Neo4jController {

    private Neo4jTemplate neo4jTemplate;
    private PersonRepository personRepository;
    private PersonRelationshipRepository personRelationshipRepository;

    private KafkaTemplate<String, String> kafkaClient;

    @Setter(AccessLevel.NONE)
    @Value("${biz.neo4j-user-guide.topic}")
    private String kafkaTopic;

    @GetMapping("/getAll")
    public String getAll() {
        ExecutableFind<Person> result = neo4jTemplate.find(Person.class);
        return result.all().toString();
    }

    @PostMapping("/add")
    public String addPerson(@RequestBody Person person) {
        Person result = neo4jTemplate.save(person);
        kafkaClient.send(kafkaTopic, GsonUtil.toJson(result));
        return GsonUtil.toJson(result);
    }

    @GetMapping("/get/{name}")
    public String getByName(@PathVariable String name) {
        List<Person> person = personRepository.findByName(name);
        if (person.isEmpty()) {
            return "No such person";
        }
        return GsonUtil.toJson(person);
    }

    @GetMapping("/cr")
    public String createRelation(@PathParam("lhs") String lhs, @PathParam("rhs") String rhs) {
        try {
            personRelationshipRepository.createRelationShipBetweenTwoPerson(lhs, rhs);
        } catch (Exception e) {
            log.error("Create relation failed.", e);
            return "fail";
        }
        return "success";
    }
}
