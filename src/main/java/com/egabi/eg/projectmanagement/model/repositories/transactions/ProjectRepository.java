package com.egabi.eg.projectmanagement.model.repositories.transactions;

import com.egabi.eg.projectmanagement.model.dto.transactions.ProjectListItem;
import com.egabi.eg.projectmanagement.model.entities.transactions.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query(value = "select new com.egabi.eg.projectmanagement.model.dto.transactions.ProjectListItem(" +
            " proj.projectCode\n" +
            ",proj.projectNameAr\n" +
            ",proj.projectNameEn\n" +
            ",proj.projectStatusId\n" +
            ",status.nameEn as projectStatusName\n" +
            ",proj.projectDescription\n" +
            ",proj.regionId\n" +
            ",region.nameEn as regionName\n" +
            ",proj.countryId\n" +
            ",country.nameEn as countryName\n" +
            ",proj.sectorId\n" +
            ",sector.nameEn as sectorName\n" +
            ",proj.projectStartDate\n" +
            ",proj.customerId\n" +
            ",cust.customerNameEn\n" +
//            ",departmentId\n" +
//            ",departmentName\n" +
            ",proj.id \n" +
            ")\n" +
            "from  \n" +
            "Customer cust\n" +
            ",LkpCountry country\n" +
//            ",LkpDepartments dept\n" +
            ",LkpStatus status\n" +
            ",LkpRegion region\n" +
            ",LkpSector sector\n" +
            ",Project proj \n" +
            "where cust.id = proj.customerId\n" +
            "and country.id = proj.countryId\n" +
//            "and dept.id = proj.departmentId\n" +
            "and status.id = proj.projectStatusId\n" +
            "and region.id = proj.regionId\n" +
            "and sector.id = proj.sectorId\n" +
            "and proj.projectStatusId = 1\n" +
//            "and proj.projectCode like %?1%\n" +
//            "and (proj.projectNameAr like '%'||:projectNameAr||'%' or :projectNameAr is null)\n" +
//            "and (upper(proj.projectNameEn) like upper('%'||:projectNameEn||'%') or :projectNameEn is null)\n" +
            "and (proj.projectNameAr like :projectNameAr or :projectNameAr is null)\n" +
            "and (proj.projectNameEn like :projectNameEn or :projectNameEn is null)\n" +
            "and (proj.projectStatusId = :projectStatusId or :projectStatusId is null) \n" +
            "and (proj.pmUser = :pmUser or :pmUser is null)\n" +
            "and( proj.projectAwardedDate >= :projectAwardedDateFrom  or :projectAwardedDateFrom is null)  \n" +
            "and( proj.projectAwardedDate > :projectAwardedDateTo  or :projectAwardedDateTo is null)  \n" +
//            "and proj.projectDescription like %?4%\n" +
            "and (proj.regionId = :regionId or :regionId is null) \n" +
            "and (proj.countryId = :countryId or :countryId is null) \n" +
            "and (proj.sectorId = :sectorId or :sectorId is null) \n" )
//            "and proj.projectStartDate = ?8\n" +
//            "and proj.customerId = ?9\n" +
    public Page<ProjectListItem> searchInProjects(String projectNameAr
            , String projectNameEn
            , Long projectStatusId
            , Long pmUser
            , LocalDate projectAwardedDateFrom
            , LocalDate projectAwardedDateTo
            , Long regionId
            , Long countryId
            , Long sectorId
            , Pageable pageable);
    
}