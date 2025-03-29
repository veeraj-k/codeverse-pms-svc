package com.veerajk.pms.repos;

import com.veerajk.pms.entities.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestCaseRepo extends JpaRepository<TestCase, Long> {
    @Query("SELECT t FROM TestCase t WHERE t.problem.id = ?1")
    public List<TestCase> findTestCasesByProblem( Long id);
}
