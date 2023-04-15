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
public class ProjectDto implements Serializable {

    private final Long id;
    @Size(max = 200)
    private final String projectCode;
    @Size(max = 500)
    private final String projectNameEn;
    @Size(max = 500)
    private final String projectNameAr;
    @Size(max = 2000)
    private String projectDescription;
    private LocalDate projectStartDate;
    private LocalDate projectEndDate;
    private LocalDate proposalSubmmissionDate;
    private LocalDate projectAwardedDate;
    private Long salesUser;
    private Long pmUser;
    private Long departmentId;
    private LkpStatusDto projectStatus;

    @JsonIgnore
    public Long setId() {
        return id;
    }
}
