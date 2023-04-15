package com.egabi.eg.projectmanagement.model.dto.transactions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProjectListItem {
    private String projectCode;
    private String projectNameAr;
    private String projectNameEn;
    private Long projectStatusId;
    private String projectStatusName;
    private String projectDescription;
    private Long   regionId;
    private String regionName;
    private Long   countryId;
    private String countryName;
    private Long   sectorId;
    private String sectorName;
    private LocalDate projectStartDate;
    private Long      customerId;
    private String customerName;
    private Long   departmentId;
    private String departmentName;
    private Long projectId;


    public ProjectListItem(String projectCode,
                           String projectNameAr,
                           String projectNameEn,
                           Long projectStatusId,
                           String projectStatusName,
                           String projectDescription,
                           Long regionId,
                           String regionName,
                           Long countryId,
                           String countryName,
                           Long sectorId,
                           String sectorName,
                           LocalDate projectStartDate,
                           Long customerId,
                           String customerName,
//                           Long departmentId, String departmentName,
                           Long projectId
    ) {
        this.projectCode = projectCode;
        this.projectNameAr = projectNameAr;
        this.projectNameEn = projectNameEn;
        this.projectStatusId = projectStatusId;
        this.projectStatusName = projectStatusName;
        this.projectDescription = projectDescription;
        this.regionId = regionId;
        this.regionName = regionName;
        this.countryId = countryId;
        this.countryName = countryName;
        this.sectorId = sectorId;
        this.sectorName = sectorName;
        this.projectStartDate = projectStartDate;
        this.customerId = customerId;
        this.customerName = customerName;
//        this.departmentId = departmentId;
//        this.departmentName = departmentName;
        this.projectId = projectId;
    }
}
