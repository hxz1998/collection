/**
 * Neo4jUserGuide
 *
 * @Description: TODO
 * @Author: cherry
 * @Create on: 2023/11/19
 **/
package org.example.repository;

import org.example.model.Person;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

public interface PersonRelationshipRepository extends Neo4jRepository<Person, String> {

    @Query("MATCH (lhs:Person),(rhs:Person) WHERE lhs.name = $lhs AND rhs.name = $rhs CREATE (lhs)-[r:Relation]->(rhs) RETURN r")
    void createRelationShipBetweenTwoPerson(String lhs, String rhs);
}
