package com.egabi.eg.projectmanagement.model.repositories.transactions;

import com.egabi.eg.projectmanagement.model.entities.transactions.ProjectContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectContractRepository extends JpaRepository<ProjectContract, Long> {
}