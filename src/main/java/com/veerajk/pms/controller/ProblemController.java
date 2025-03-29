package com.veerajk.pms.controller;

import com.veerajk.pms.dtos.ProblemDTO;
import com.veerajk.pms.dtos.ProblemRunnerDTO;
import com.veerajk.pms.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/problems/")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping
    private ResponseEntity<List<ProblemDTO>> getAllProblems(){
        List<ProblemDTO> problems = problemService.getAllProblems();
        return ResponseEntity.ok(problems);
    }

    @GetMapping("{id}")
    private ResponseEntity<ProblemDTO> getProblemById(@PathVariable Long id){
        ProblemDTO problem = problemService.getProblemById(id);
        return ResponseEntity.ok(problem);
    }

    @PostMapping
    private ResponseEntity<ProblemDTO> createProblem(@RequestBody ProblemDTO problemDTO){
        ProblemDTO problem = problemService.createProblem(problemDTO);
        return new ResponseEntity<>(problem, HttpStatus.CREATED);
    }
    @PutMapping
    private ResponseEntity<ProblemDTO> updateProblem(@RequestBody ProblemDTO problemDTO){
        ProblemDTO updateProblem = problemService.updateProblem(problemDTO);
        return ResponseEntity.ok(updateProblem);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<String> deleteProblem(@PathVariable Long id){
        String message = problemService.deleteProblem(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("{id}/runner")
    private ResponseEntity<ProblemRunnerDTO> getProblemRunner(@PathVariable Long id){
        ProblemRunnerDTO problemRunnerDTO = problemService.getProblemRunner(id);
        return ResponseEntity.ok(problemRunnerDTO);
    }

}
