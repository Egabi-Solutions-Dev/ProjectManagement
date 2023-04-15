package com.egabi.eg.projectmanagement.model.entities.lkp;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "LKP_CURRENCIES")
public class LkpCurrency extends BaseLkpEntity<Long> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "CURRENCY_ID", nullable = false)
//    private Long id;

    @Size(max = 100)
    @Column(name = "CURRENCY_CODE", length = 100)
    private String currencyCode;

    @Size(max = 100)
    @Column(name = "NAME_EN", length = 100)
    private String nameEn;

    @Size(max = 100)
    @Column(name = "NAME_AR", length = 100)
    private String nameAr;

//    @Column(name = "IS_DELETED")
//    private Boolean isDeleted;

}