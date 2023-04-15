package com.egabi.eg.projectmanagement.model.repositories.transactions;

import com.egabi.eg.projectmanagement.model.entities.transactions.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}