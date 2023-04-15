package com.egabi.eg.projectmanagement.model.mapper.dto;

import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class LkpStatusDto implements Serializable {
    private final Long id;
    private final Boolean isDeleted;
    @Size(max = 200)
    private final String nameEn;
    @Size(max = 200)
    private final String nameAr;
    @Size(max = 50)
    private final String statusType;
}
