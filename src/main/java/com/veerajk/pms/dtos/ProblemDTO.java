package com.veerajk.pms.dtos;

import com.veerajk.pms.entities.Problem;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProblemDTO {

    private Long id;
    private String title;
    private String description;
    private List<String> constraints;
    private List<String> examples;
    private List<TestCaseDTO> testCases = new ArrayList<>();

}
