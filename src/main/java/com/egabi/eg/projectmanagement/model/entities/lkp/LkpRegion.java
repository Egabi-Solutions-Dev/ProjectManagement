package com.egabi.eg.projectmanagement.model.entities.lkp;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "LKP_REGIONS")
public class LkpRegion extends BaseLkpEntity<Long> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "REGION_ID", nullable = false)
//    private Long id;

    @Size(max = 100)
    @Column(name = "REGION_CODE", length = 100)
    private String regionCode;

    @Size(max = 200)
    @Column(name = "NAME_EN", length = 200)
    private String nameEn;

    @Size(max = 200)
    @Column(name = "NAME_AR", length = 200)
    private String nameAr;

//    @Column(name = "IS_DELETED")
//    private Boolean isDeleted;
}