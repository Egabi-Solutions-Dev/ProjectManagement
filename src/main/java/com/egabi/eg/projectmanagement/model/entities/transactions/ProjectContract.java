package com.egabi.eg.projectmanagement.model.entities.transactions;

import com.egabi.eg.projectmanagement.model.entities.lkp.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "PROJECT_CONTRACTS")
public class ProjectContract {
    @Id
    @Column(name = "CONTRACT_ID", nullable = false)
    private Long id;

    @Size(max = 200)
    @Column(name = "CONTRACT_CODE", length = 200)
    private String contractCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @Column(name = "SIGNNING_DATE")
    private LocalDate signningDate;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "ACTUAL_START_DATE")
    private LocalDate actualStartDate;

    @Column(name = "ACTUAL_END_DATE")
    private LocalDate actualEndDate;

    @Column(name = "CONTRACT_DURATION")
    private Long contractDuration;

    @Column(name = "ALLOCATED_RESOURCE_NO")
    private Long allocatedResourceNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REGION_ID")
    private LkpRegion region;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COUNTRY_ID")
    private LkpCountry country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTORE_ID")
    private LkpSector sectore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private LkpCurrency currency;

    @Column(name = "SALES_USER")
    private Long salesUser;

    @Column(name = "PM_USER")
    private Long pmUser;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "EXCHANGE_RATE_AT_CON_SIGN")
    private Long exchangeRateAtConSign;

    @Column(name = "AMOUNT_EGP")
    private Long amountEgp;

    @Column(name = "AMOUNT_WITH_VAT_EGP")
    private Long amountWithVatEgp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_LINE_ID")
    private LkpBusinessLine businessLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_SUB_LINE_ID")
    private LkpBusinessSubLine buisnessSubLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONTRACT_STATUS")
    private LkpStatus contractStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENGAGMENT_TYPE")
    private LkpEngagmentType engagmentType;

    @Column(name = "AMOUNT_USD")
    private Long amountUsd;

    @Column(name = "AMOUNT_WITH_VAT_USD")
    private Long amountWithVatUsd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDate getSignningDate() {
        return signningDate;
    }

    public void setSignningDate(LocalDate signningDate) {
        this.signningDate = signningDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getActualStartDate() {
        return actualStartDate;
    }

    public void setActualStartDate(LocalDate actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public LocalDate getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(LocalDate actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public Long getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(Long contractDuration) {
        this.contractDuration = contractDuration;
    }

    public Long getAllocatedResourceNo() {
        return allocatedResourceNo;
    }

    public void setAllocatedResourceNo(Long allocatedResourceNo) {
        this.allocatedResourceNo = allocatedResourceNo;
    }

    public LkpRegion getRegion() {
        return region;
    }

    public void setRegion(LkpRegion region) {
        this.region = region;
    }

    public LkpCountry getCountry() {
        return country;
    }

    public void setCountry(LkpCountry country) {
        this.country = country;
    }

    public LkpSector getSectore() {
        return sectore;
    }

    public void setSectore(LkpSector sectore) {
        this.sectore = sectore;
    }

    public LkpCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(LkpCurrency currency) {
        this.currency = currency;
    }

    public Long getSalesUser() {
        return salesUser;
    }

    public void setSalesUser(Long salesUser) {
        this.salesUser = salesUser;
    }

    public Long getPmUser() {
        return pmUser;
    }

    public void setPmUser(Long pmUser) {
        this.pmUser = pmUser;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getExchangeRateAtConSign() {
        return exchangeRateAtConSign;
    }

    public void setExchangeRateAtConSign(Long exchangeRateAtConSign) {
        this.exchangeRateAtConSign = exchangeRateAtConSign;
    }

    public Long getAmountEgp() {
        return amountEgp;
    }

    public void setAmountEgp(Long amountEgp) {
        this.amountEgp = amountEgp;
    }

    public Long getAmountWithVatEgp() {
        return amountWithVatEgp;
    }

    public void setAmountWithVatEgp(Long amountWithVatEgp) {
        this.amountWithVatEgp = amountWithVatEgp;
    }

    public LkpBusinessLine getBusinessLine() {
        return businessLine;
    }

    public void setBusinessLine(LkpBusinessLine businessLine) {
        this.businessLine = businessLine;
    }

    public LkpBusinessSubLine getBuisnessSubLine() {
        return buisnessSubLine;
    }

    public void setBuisnessSubLine(LkpBusinessSubLine buisnessSubLine) {
        this.buisnessSubLine = buisnessSubLine;
    }

    public LkpStatus getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(LkpStatus contractStatus) {
        this.contractStatus = contractStatus;
    }

    public LkpEngagmentType getEngagmentType() {
        return engagmentType;
    }

    public void setEngagmentType(LkpEngagmentType engagmentType) {
        this.engagmentType = engagmentType;
    }

    public Long getAmountUsd() {
        return amountUsd;
    }

    public void setAmountUsd(Long amountUsd) {
        this.amountUsd = amountUsd;
    }

    public Long getAmountWithVatUsd() {
        return amountWithVatUsd;
    }

    public void setAmountWithVatUsd(Long amountWithVatUsd) {
        this.amountWithVatUsd = amountWithVatUsd;
    }

}