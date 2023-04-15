package com.egabi.eg.projectmanagement.model.repositories.transactions;

import com.egabi.eg.projectmanagement.model.entities.transactions.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Long> {
}