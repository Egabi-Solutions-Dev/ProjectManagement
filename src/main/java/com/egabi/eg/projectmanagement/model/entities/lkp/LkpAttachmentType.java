package com.egabi.eg.projectmanagement.model.entities.lkp;


import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "LKP_ATTACHMENT_TYPES")
public class LkpAttachmentType extends BaseLkpEntity<Long> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ATTACHMENT_TYPE_ID", nullable = false)
//    private Long id;

    @Size(max = 100)
    @Column(name = "NAME_AR", length = 100)
    private String nameAr;

    @Size(max = 100)
    @Column(name = "NAME_EN", length = 100)
    private String nameEn;

    @Size(max = 200)
    @Column(name = "ECM_TYPE_NAME", length = 200)
    private String ecmTypeName;

//    @Column(name = "IS_DELETED")
//    private Boolean isDeleted;

}

