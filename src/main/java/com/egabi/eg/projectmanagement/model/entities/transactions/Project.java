package com.egabi.eg.projectmanagement.model.entities.transactions;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpCountry;
import com.egabi.eg.projectmanagement.model.entities.lkp.LkpRegion;
import com.egabi.eg.projectmanagement.model.entities.lkp.LkpSector;
import com.egabi.eg.projectmanagement.model.entities.lkp.LkpStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "PROJECTS")
@Getter @Setter
public class Project {
    @Id
    @Column(name = "PROJECT_ID", nullable = false)
    private Long id;

    @Size(max = 200)
    @Column(name = "PROJECT_CODE", length = 200)
    private String projectCode;

    @Size(max = 500)
    @Column(name = "PROJECT_NAME_EN", length = 500)
    private String projectNameEn;

    @Size(max = 500)
    @Column(name = "PROJECT_NAME_AR", length = 500)
    private String projectNameAr;

    @Size(max = 2000)
    @Column(name = "PROJECT_DESCRIPTION", length = 2000)
    private String projectDescription;

    @Column(name = "PROJECT_START_DATE")
    private LocalDate projectStartDate;

    @Column(name = "PROJECT_END_DATE")
    private LocalDate projectEndDate;

    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "COUNTRY_ID")
    private Long countryId;

    @Column(name = "SECTORE_ID")
    private Long sectorId;

    @Column(name = "PROPOSAL_SUBMMISSION_DATE")
    private LocalDate proposalSubmmissionDate;

    @Column(name = "CUSTOMER_ID")
    private Long customerId;

    @Column(name = "PROJECT_AWARDED_DATE")
    private LocalDate projectAwardedDate;

    @Column(name = "SALES_USER")
    private Long salesUser;

    @Column(name = "PM_USER")
    private Long pmUser;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "PROJECT_STATUS")
    private Long projectStatusId;


}