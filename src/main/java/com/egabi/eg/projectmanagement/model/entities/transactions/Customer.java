package com.egabi.eg.projectmanagement.model.entities.transactions;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpCountry;
import com.egabi.eg.projectmanagement.model.entities.lkp.LkpRegion;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    @Id
    @Column(name = "CUSTOMER_ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "CUSTOMER_CODE", length = 100)
    private String customerCode;

    @Size(max = 500)
    @Column(name = "CUSTOMER_NAME_EN", length = 500)
    private String customerNameEn;

    @Size(max = 500)
    @Column(name = "CUSTOMER_NAME_AR", length = 500)
    private String customerNameAr;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTUMER_COUNTRY_ID")
    private LkpCountry custumerCountry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_REGION_ID")
    private LkpRegion customerRegion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerNameEn() {
        return customerNameEn;
    }

    public void setCustomerNameEn(String customerNameEn) {
        this.customerNameEn = customerNameEn;
    }

    public String getCustomerNameAr() {
        return customerNameAr;
    }

    public void setCustomerNameAr(String customerNameAr) {
        this.customerNameAr = customerNameAr;
    }

    public LkpCountry getCustumerCountry() {
        return custumerCountry;
    }

    public void setCustumerCountry(LkpCountry custumerCountry) {
        this.custumerCountry = custumerCountry;
    }

    public LkpRegion getCustomerRegion() {
        return customerRegion;
    }

    public void setCustomerRegion(LkpRegion customerRegion) {
        this.customerRegion = customerRegion;
    }

}