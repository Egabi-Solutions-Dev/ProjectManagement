package com.egabi.eg.projectmanagement.model.mapper.dto;

import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class LkpBusinessLineDto implements Serializable {
    private final Long id;
    private final Boolean isDeleted;
    @Size(max = 100)
    private final String nameEn;
    @Size(max = 100)
    private final String nameAr;
}
