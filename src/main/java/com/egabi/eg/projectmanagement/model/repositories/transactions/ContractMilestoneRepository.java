package com.egabi.eg.projectmanagement.model.repositories.transactions;

import com.egabi.eg.projectmanagement.model.entities.transactions.ContractMilestone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractMilestoneRepository extends JpaRepository<ContractMilestone, Long> {
}