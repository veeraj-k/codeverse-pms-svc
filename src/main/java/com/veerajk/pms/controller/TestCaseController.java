package com.veerajk.pms.controller;

import com.veerajk.pms.dtos.TestCaseDTO;
import com.veerajk.pms.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems/")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;
    @GetMapping("/{problemId}/testcases")
    public ResponseEntity<List<TestCaseDTO>> getTestCasesOfProblem(@PathVariable Long problemId){
        return ResponseEntity.ok(testCaseService.getTestCasesOfProblem(problemId));
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCaseDTO> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.getTestCaseById(id));
    }

    @PostMapping("{problemId}/testcases")
    public ResponseEntity<TestCaseDTO> createTestCase(@PathVariable Long problemId, @RequestBody TestCaseDTO testCaseDTO){
        return new ResponseEntity<>(testCaseService.createTestCase(problemId,testCaseDTO), HttpStatus.CREATED);
    }

    @PutMapping("/testcases")
    public ResponseEntity<TestCaseDTO> updateTestCase(@RequestBody TestCaseDTO testCaseDTO){
        return ResponseEntity.ok(testCaseService.updateTestCaseById(testCaseDTO));
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<String > deleteTestCase(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.deleteTestCase(id));
    }

//    also add upload test cases by sheets
}

