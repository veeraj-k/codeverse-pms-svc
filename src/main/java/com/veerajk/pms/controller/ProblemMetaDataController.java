package com.veerajk.pms.controller;

import com.veerajk.pms.entities.ProblemMetaData;
import com.veerajk.pms.repos.ProblemMetaDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/problems/")
public class ProblemMetaDataController {

    @Autowired
    private ProblemMetaDataRepo repo;

    @GetMapping("{id}/metadata/{language}")
    public ResponseEntity<ProblemMetaData> getProblemMetaData(@PathVariable Long id,@PathVariable String language){
        ProblemMetaData problemMetaData = repo.findByProblemIdAndLanguage(id, language).get();
        return ResponseEntity.ok(problemMetaData);
    }

    @PostMapping("createMetadata")
    public ResponseEntity<ProblemMetaData> createProblemMetaData(@RequestBody ProblemMetaData problemMetaData){
        ProblemMetaData problemMetaData1 = repo.save(problemMetaData);
        return ResponseEntity.ok(problemMetaData1);
    }
}
