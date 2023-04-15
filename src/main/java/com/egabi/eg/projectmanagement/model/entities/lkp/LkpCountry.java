package com.egabi.eg.projectmanagement.model.entities.lkp;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
@Data
@Entity
@Table(name = "LKP_COUNTRIES")
public class LkpCountry extends BaseLkpEntity<Long> {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "COUNTRY_ID", nullable = false)
//    private Long id;

    @Size(max = 200)
    @Column(name = "NAME_EN", length = 200)
    private String nameEn;

    @Size(max = 200)
    @Column(name = "NAME_AR", length = 200)
    private String nameAr;

    @Size(max = 20)
    @Column(name = "POSTAL_CODE", length = 20)
    private String postalCode;

    @Size(max = 200)
    @Column(name = "COUNTRY_CODE", length = 200)
    private String countryCode;

//    @Column(name = "IS_DELETED")
//    private Boolean isDeleted;

}