package com.egabi.eg.projectmanagement.model.dto.transactions;

import com.egabi.eg.projectmanagement.model.mapper.dto.LkpStatusDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data @Getter @Setter
public class ProjectSearchReqDto implements Serializable {

    private final Long id;
    private final String projectCode;
    private final String projectNameEn;
    private final String projectNameAr;
//    private String projectDescription;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private LocalDate proposalSubmmissionDate;
    private LocalDate projectAwardedDate;
    private Long salesUser;
    private Long pmUser;
    private Long departmentId;
    private Long projectStatusId;

    private Long   regionId;
    private String regionName;
    private Long   countryId;
    private String countryName;
    private Long   sectorId;
    private String sectorName;
    private Long   customerId;
    private String customerName;

    LocalDate projectAwardedDateFrom;
    LocalDate projectAwardedDateTo;

    @JsonIgnore
    public Long setId() {
        return id;
    }
}
