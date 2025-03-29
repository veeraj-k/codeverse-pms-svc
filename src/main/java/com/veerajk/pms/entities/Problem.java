package com.veerajk.pms.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    private String difficulty;
    private String description;

    @ElementCollection
    private List<String> constraints;
    @ElementCollection
    private List<String> examples;

    @OneToMany(mappedBy = "problem",cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    private List<TestCase> testCases;

}
