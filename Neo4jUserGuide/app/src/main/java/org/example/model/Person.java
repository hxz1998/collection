/**
 * Neo4jUserGuide
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/19
 **/
package org.example.model;

import java.util.List;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node(labels = "Person")
@Data
public class Person {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private int age;
    private String sex;
    private String birthday;
    private boolean married;

    @Relationship("Relation")
    private List<Person> relation;
}
