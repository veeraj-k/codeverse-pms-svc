package com.veerajk.pms.repos;

import com.veerajk.pms.entities.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProblemRepo extends JpaRepository<Problem, Long> {

}
