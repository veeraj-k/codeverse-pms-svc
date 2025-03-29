package com.veerajk.pms.service;

import com.veerajk.pms.dtos.TestCaseDTO;
import com.veerajk.pms.dtos.mappers.ProblemDTOMapper;
import com.veerajk.pms.dtos.mappers.TestCaseDTOMapper;
import com.veerajk.pms.entities.Problem;
import com.veerajk.pms.entities.TestCase;
import com.veerajk.pms.exceptionhandler.exceptions.ProblemNotFoundException;
import com.veerajk.pms.repos.ProblemRepo;
import com.veerajk.pms.repos.TestCaseRepo;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestCaseService {
    @Autowired
    private TestCaseRepo testCaseRepo;
    @Autowired
    private ProblemRepo problemRepo;

    @SneakyThrows
    public List<TestCaseDTO> getTestCasesOfProblem(Long problemId) {
        try{
            return testCaseRepo.findTestCasesByProblem(problemId)
                    .stream()
                    .map(TestCaseDTOMapper::toTestCaseDTO)
                    .collect(Collectors.toList());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        throw new Exception("Couldn't Retrive testcases");

    }


    public TestCaseDTO getTestCaseById(Long id) {
        Optional<TestCase> testCase = testCaseRepo.findById(id);
        if(testCase.isEmpty()){
            throw new ProblemNotFoundException("TestCase with id:"+id+" not found");
        }
        return TestCaseDTOMapper.toTestCaseDTO(testCase.get());
    }

    @SneakyThrows
    public TestCaseDTO createTestCase(Long problemId, TestCaseDTO testCaseDTO) {
        try{
            System.out.println(problemId);
            Optional<Problem> problem = problemRepo.findById(problemId);
            if(problem.isEmpty()){
                throw new ProblemNotFoundException("Problem with id: "+ problemId+"not found");
            }
            TestCase newTestCase = TestCaseDTOMapper.toEntity(testCaseDTO,problem.get());
            newTestCase= testCaseRepo.save(newTestCase);
            return TestCaseDTOMapper.toTestCaseDTO(newTestCase);
        }catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Error creating problem");
        }

    }
@SneakyThrows
    public TestCaseDTO updateTestCaseById(TestCaseDTO testCaseDTO) {
        Optional<Problem> problem = problemRepo.findById(testCaseDTO.getProblemId());

        if(problem.isEmpty()){
            throw new ProblemNotFoundException("Problem with id: not found");
        }

        return TestCaseDTOMapper.toTestCaseDTO(TestCaseDTOMapper.toEntity(testCaseDTO,problem.get()));
    }

    @SneakyThrows
    @Transactional
    public String deleteTestCase(Long id) {
        if(testCaseRepo.findById(id).isEmpty()) throw new ProblemNotFoundException("Test Case with id:"+id+" not found");
        testCaseRepo.deleteById(id);
        return "Delete Successful";
    }
}
