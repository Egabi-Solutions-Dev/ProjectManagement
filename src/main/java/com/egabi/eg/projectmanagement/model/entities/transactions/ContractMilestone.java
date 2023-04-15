package com.egabi.eg.projectmanagement.model.entities.transactions;

import com.egabi.eg.projectmanagement.model.entities.lkp.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "CONTRACT_MILESTONES")
public class ContractMilestone {
    @Id
    @Column(name = "MILESTONE_ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "MILESTONE_CODE", length = 100)
    private String milestoneCode;

    @Column(name = "DELIVERY_ORDER")
    private Long deliveryOrder;

    @Column(name = "DELIVERY_DATE")
    private LocalDate deliveryDate;

    @Column(name = "ACTUAL_DELIVERY_DATE")
    private LocalDate actualDeliveryDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MILESTONE_STATUS")
    private LkpStatus milestoneStatus;

    @Size(max = 4000)
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @Size(max = 4000)
    @Column(name = "DELIVERAIBLE", length = 4000)
    private String deliveraible;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "AMOUNT_EGP")
    private Long amountEgp;

    @Column(name = "AMOUNT_WITH_VAT_EGP")
    private Long amountWithVatEgp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private LkpCurrency currency;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @Column(name = "ACTUAL_START_DATE")
    private LocalDate actualStartDate;

    @Column(name = "ACTUAL_END_DATE")
    private LocalDate actualEndDate;

    @Column(name = "ALLOCATED_RESOURCES")
    private Long allocatedResources;

    @Column(name = "MILESTONE_DURATION")
    private Long milestoneDuration;

    @Column(name = "PM_USER")
    private Long pmUser;

    @Column(name = "SECTORE_MANAGER_USER")
    private Long sectoreManagerUser;

    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_LINE_ID")
    private LkpBusinessLine businessLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUSINESS_SUB_LINE_ID")
    private LkpBusinessSubLine buisnessSubLine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ENGAGMENT_TYPE")
    private LkpEngagmentType engagmentType;

    @Column(name = "VAT_PERCENT")
    private Long vatPercent;

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

    public String getMilestoneCode() {
        return milestoneCode;
    }

    public void setMilestoneCode(String milestoneCode) {
        this.milestoneCode = milestoneCode;
    }

    public Long getDeliveryOrder() {
        return deliveryOrder;
    }

    public void setDeliveryOrder(Long deliveryOrder) {
        this.deliveryOrder = deliveryOrder;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public LocalDate getActualDeliveryDate() {
        return actualDeliveryDate;
    }

    public void setActualDeliveryDate(LocalDate actualDeliveryDate) {
        this.actualDeliveryDate = actualDeliveryDate;
    }

    public LkpStatus getMilestoneStatus() {
        return milestoneStatus;
    }

    public void setMilestoneStatus(LkpStatus milestoneStatus) {
        this.milestoneStatus = milestoneStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeliveraible() {
        return deliveraible;
    }

    public void setDeliveraible(String deliveraible) {
        this.deliveraible = deliveraible;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
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

    public LkpCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(LkpCurrency currency) {
        this.currency = currency;
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

    public Long getAllocatedResources() {
        return allocatedResources;
    }

    public void setAllocatedResources(Long allocatedResources) {
        this.allocatedResources = allocatedResources;
    }

    public Long getMilestoneDuration() {
        return milestoneDuration;
    }

    public void setMilestoneDuration(Long milestoneDuration) {
        this.milestoneDuration = milestoneDuration;
    }

    public Long getPmUser() {
        return pmUser;
    }

    public void setPmUser(Long pmUser) {
        this.pmUser = pmUser;
    }

    public Long getSectoreManagerUser() {
        return sectoreManagerUser;
    }

    public void setSectoreManagerUser(Long sectoreManagerUser) {
        this.sectoreManagerUser = sectoreManagerUser;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
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

    public LkpEngagmentType getEngagmentType() {
        return engagmentType;
    }

    public void setEngagmentType(LkpEngagmentType engagmentType) {
        this.engagmentType = engagmentType;
    }

    public Long getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(Long vatPercent) {
        this.vatPercent = vatPercent;
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