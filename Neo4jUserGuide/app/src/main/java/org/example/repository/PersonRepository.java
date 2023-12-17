/**
 * Neo4jUserGuide
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/19
 **/
package org.example.repository;

import java.util.List;
import org.example.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;


public interface PersonRepository extends Neo4jRepository<Person, String> {

    @Query("MATCH (person: Person) WHERE person.name = $name RETURN person")
    List<Person> findByName(String name);

}
