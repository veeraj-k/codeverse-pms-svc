package com.veerajk.pms.dtos.mappers;

import com.veerajk.pms.dtos.ProblemDTO;
import com.veerajk.pms.dtos.TestCaseDTO;
import com.veerajk.pms.entities.Problem;
import com.veerajk.pms.entities.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemDTOMapper {
    public static ProblemDTO toProblemDto(Problem problem) {
        return ProblemDTO.builder()
                .id(problem.getId())
                .title(problem.getTitle())
                .description(problem.getDescription())
                .constraints(problem.getConstraints())
                .examples(problem.getExamples())
                .testCases(problem.getTestCases()!=null? problem.getTestCases().stream()
                        .map(TestCaseDTOMapper::toTestCaseDTO)
                        .collect(Collectors.toList()): new ArrayList<>())
                .build();
    }
    public static Problem toEntity(ProblemDTO problemDTO) {

        Problem problem = Problem.builder()
                .id(problemDTO.getId() != null ? problemDTO.getId() : null)
                .title(problemDTO.getTitle())
                .description(problemDTO.getDescription())
                .examples(problemDTO.getExamples())
                .constraints(problemDTO.getConstraints())
                .build();
        if(problemDTO.getTestCases() !=null){
            List<TestCase> testCases = problemDTO.getTestCases()
                    .stream().map(testCaseDTO -> TestCaseDTOMapper.toEntity(testCaseDTO,problem))
                    .toList();
            problem.setTestCases(testCases);
        }
        return problem;

    }


}
