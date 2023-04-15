package com.egabi.eg.projectmanagement.model.entities.lkp;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "LKP_STATUS")
public class LkpStatus extends BaseLkpEntity <Long> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "STATUS_ID", nullable = false)
//    private Long id;

    @Size(max = 200)
    @Column(name = "NAME_EN", length = 200)
    private String nameEn;

    @Size(max = 200)
    @Column(name = "NAME_AR", length = 200)
    private String nameAr;

    @Size(max = 50)
    @Column(name = "STATUS_TYPE", length = 50)
    private String statusType;

//    @Column(name = "IS_DELETED")
//    private Boolean isDeleted;

}