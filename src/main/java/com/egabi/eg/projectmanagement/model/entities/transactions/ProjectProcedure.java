package com.egabi.eg.projectmanagement.model.entities.transactions;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "PROJECT_PROCEDURES")
public class ProjectProcedure {
    @Id
    @Column(name = "PROCEDURE_ID", nullable = false)
    private Long id;

    @Column(name = "PROJECT_ID")
    private Long projectId;

    @Size(max = 1000)
    @Column(name = "PROCEDURE_DESC", length = 1000)
    private String procedureDesc;

    @Column(name = "PROCEDURE_TYPE")
    private Long procedureType;

    @Column(name = "PROCEDURE_DATE")
    private LocalDate procedureDate;

    @Column(name = "PROCEDURE_USER")
    private Long procedureUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProcedureDesc() {
        return procedureDesc;
    }

    public void setProcedureDesc(String procedureDesc) {
        this.procedureDesc = procedureDesc;
    }

    public Long getProcedureType() {
        return procedureType;
    }

    public void setProcedureType(Long procedureType) {
        this.procedureType = procedureType;
    }

    public LocalDate getProcedureDate() {
        return procedureDate;
    }

    public void setProcedureDate(LocalDate procedureDate) {
        this.procedureDate = procedureDate;
    }

    public Long getProcedureUser() {
        return procedureUser;
    }

    public void setProcedureUser(Long procedureUser) {
        this.procedureUser = procedureUser;
    }

}