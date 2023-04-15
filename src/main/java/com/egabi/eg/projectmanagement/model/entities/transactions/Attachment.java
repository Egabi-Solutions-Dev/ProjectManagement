package com.egabi.eg.projectmanagement.model.entities.transactions;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "ATTACHMENTS")
public class Attachment {
    @Id
    @Column(name = "ATTACHMENT_ID", nullable = false)
    private Long id;

    @Size(max = 1000)
    @Column(name = "ATTACHMENT_DESC", length = 1000)
    private String attachmentDesc;

    @Column(name = "ATTACHMENT_TYPE")
    private Long attachmentType;

    @Column(name = "ATTACHMENT_DATE")
    private LocalDate attachmentDate;

    @Size(max = 500)
    @Column(name = "ECM_DOC_NAME", length = 500)
    private String ecmDocName;

    @Lob
    @Column(name = "ATTACHMENT_FILE")
    private byte[] attachmentFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAttachmentDesc() {
        return attachmentDesc;
    }

    public void setAttachmentDesc(String attachmentDesc) {
        this.attachmentDesc = attachmentDesc;
    }

    public Long getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(Long attachmentType) {
        this.attachmentType = attachmentType;
    }

    public LocalDate getAttachmentDate() {
        return attachmentDate;
    }

    public void setAttachmentDate(LocalDate attachmentDate) {
        this.attachmentDate = attachmentDate;
    }

    public String getEcmDocName() {
        return ecmDocName;
    }

    public void setEcmDocName(String ecmDocName) {
        this.ecmDocName = ecmDocName;
    }

    public byte[] getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(byte[] attachmentFile) {
        this.attachmentFile = attachmentFile;
    }

}