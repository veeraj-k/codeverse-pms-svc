package com.veerajk.pms.repos;

import com.veerajk.pms.entities.ProblemMetaData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProblemMetaDataRepo extends JpaRepository<ProblemMetaData,Long> {

     Optional<ProblemMetaData> findByProblemIdAndLanguage(Long problemId,String language);
}
