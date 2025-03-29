package com.veerajk.pms.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"problem_id","language"}))
public class ProblemMetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Long id;

    @Column(name = "problem_id")
    public Long problemId;

    public String language;
    @Column(columnDefinition="TEXT")
    public String runner;
    @Column(columnDefinition="TEXT")
    public String evaluator;

}

