package com.veerajk.pms.dtos.mappers;

import com.veerajk.pms.dtos.TestCaseDTO;
import com.veerajk.pms.entities.Problem;
import com.veerajk.pms.entities.TestCase;

public class TestCaseDTOMapper {

    public static TestCaseDTO toTestCaseDTO(TestCase testCase) {
        return TestCaseDTO.builder()
                .id(testCase.getId())
                .input(testCase.getInput())
                .output(testCase.getOutput())
                .problemId(testCase.getProblem().getId())
                .build();
    }

    public static TestCase toEntity(TestCaseDTO testCaseDTO, Problem problem) {
        return TestCase.builder()
                .id(testCaseDTO.getId() != null ? testCaseDTO.getId() : null)
                .input(testCaseDTO.getInput())
                .output(testCaseDTO.getOutput())
                .problem(problem)
                .build();
    }
}
