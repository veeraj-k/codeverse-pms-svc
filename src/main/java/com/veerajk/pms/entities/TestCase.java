package com.veerajk.pms.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.JsonNode;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "input",columnDefinition = "jsonb")
    private Map<String ,Object> input;


    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "output",columnDefinition = "jsonb")
    private Map<String ,Object> output;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

}
