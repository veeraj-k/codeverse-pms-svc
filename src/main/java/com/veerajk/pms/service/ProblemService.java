package com.veerajk.pms.service;

import com.veerajk.pms.dtos.ProblemDTO;
import com.veerajk.pms.dtos.ProblemRunnerDTO;
import com.veerajk.pms.dtos.mappers.ProblemDTOMapper;
import com.veerajk.pms.entities.Problem;
import com.veerajk.pms.exceptionhandler.exceptions.ProblemNotFoundException;
import com.veerajk.pms.repos.ProblemRepo;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProblemService {

    @Autowired
    private ProblemRepo problemRepo;

    @SneakyThrows
    public List<ProblemDTO> getAllProblems() {
        try{
            return problemRepo.findAll()
                    .stream()
                    .map(ProblemDTOMapper::toProblemDto)
                    .collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new Exception("Couldn't retrieve problems");
    }

    @SneakyThrows
    public ProblemDTO getProblemById(Long id) {
        System.out.println("Database HIT");
        Optional<Problem> problem = problemRepo.findById(id);
        if(problem.isEmpty()){
            throw new ProblemNotFoundException("Problem with id:"+id+" not found");
        }
        return ProblemDTOMapper.toProblemDto(problem.get());
    }

    @SneakyThrows
    public ProblemDTO createProblem(ProblemDTO problemDTO) {
        try{
            Problem newProblem = ProblemDTOMapper.toEntity(problemDTO);
            newProblem= problemRepo.save(newProblem);
            return ProblemDTOMapper.toProblemDto(newProblem);
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("Error creating problem");
        }
    }
    @SneakyThrows
    public ProblemDTO updateProblem(ProblemDTO problemDTO) {
        return ProblemDTOMapper.toProblemDto(problemRepo.save(ProblemDTOMapper.toEntity(problemDTO)));
    }

    @Transactional
    @SneakyThrows
    public String deleteProblem(Long id) {
        if(problemRepo.findById(id).isEmpty()) throw new ProblemNotFoundException("Problem with id:"+id+" not found");
        problemRepo.deleteById(id);
        return "Delete Successful";
    }

    public ProblemRunnerDTO getProblemRunner(Long id) {
        Optional<Problem> problem = problemRepo.findById(id);
        if(problem.isEmpty()){
            throw new ProblemNotFoundException("Problem with id:"+id+" not found");
        }



        return null;
    }
}
