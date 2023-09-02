package com.example.neo4jdemo;

import com.example.neo4jdemo.model.Person;
import com.example.neo4jdemo.repo.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Neo4jDemoApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void contextLoads() {
        Person person = new Person();
        person.setName("小明");
        personRepository.save(person);
    }

}
