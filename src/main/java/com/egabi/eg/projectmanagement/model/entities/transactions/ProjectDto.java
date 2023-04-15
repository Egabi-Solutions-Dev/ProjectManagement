package com.egabi.eg.projectmanagement.model.entities.transactions;

import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ProjectDto implements Serializable {
    private final Long id;
    @Size(max = 200)
    private final String projectCode;
    @Size(max = 500)
    private final String projectNameEn;
    @Size(max = 500)
    private final String projectNameAr;
    @Size(max = 2000)
    private final String projectDescription;
    private final LocalDate projectStartDate;
    private final LocalDate projectEndDate;
    private final LocalDate proposalSubmmissionDate;
    private final LocalDate projectAwardedDate;
    private final Long salesUser;
    private final Long pmUser;
    private final Long departmentId;

}
