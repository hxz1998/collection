/**
 * neo4j-demo
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/9/2
 **/
package com.example.neo4jdemo.model;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@Node
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String name;
}
