package com.egabi.eg.projectmanagement.model.repositories.transactions;

import com.egabi.eg.projectmanagement.model.entities.transactions.ProjectProcedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectProcedureRepository extends JpaRepository<ProjectProcedure, Long> {
}