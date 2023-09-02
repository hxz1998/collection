/**
 * neo4j-demo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/9/2
 **/
package com.example.neo4jdemo.repo;

import com.example.neo4jdemo.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

}
