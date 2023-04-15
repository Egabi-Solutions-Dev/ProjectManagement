package com.egabi.eg.projectmanagement.model.entities.lkp;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "LKP_BUSINESS_SUB_LINES")
public class LkpBusinessSubLine extends BaseLkpEntity<Long>  {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "SUB_LINE_ID", nullable = false)
//    private Long id;

    @Size(max = 100)
    @Column(name = "NAME_EN", length = 100)
    private String nameEn;

    @Size(max = 100)
    @Column(name = "NAME_AR", length = 100)
    private String nameAr;

//    @Column(name = "IS_DELETED")
//    private Boolean isDeleted;



}