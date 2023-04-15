package com.egabi.eg.projectmanagement.model.entities.transactions;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "MILESTONE_DELIVERABLES")
public class MilestoneDeliverable {
    @Id
    @Column(name = "DELIVERABLE_ID", nullable = false)
    private Long id;

    @Size(max = 4000)
    @Column(name = "DELIVERABLE_DESC", length = 4000)
    private String deliverableDesc;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "AMOUNT_EGP")
    private Long amountEgp;

    @Column(name = "AMOUNT_WITH_VAT_EGP")
    private Long amountWithVatEgp;

    @Column(name = "VAT_PERCENT")
    private Long vatPercent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MILESTONE_ID")
    private ContractMilestone milestone;

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

    public String getDeliverableDesc() {
        return deliverableDesc;
    }

    public void setDeliverableDesc(String deliverableDesc) {
        this.deliverableDesc = deliverableDesc;
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

    public Long getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(Long vatPercent) {
        this.vatPercent = vatPercent;
    }

    public ContractMilestone getMilestone() {
        return milestone;
    }

    public void setMilestone(ContractMilestone milestone) {
        this.milestone = milestone;
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