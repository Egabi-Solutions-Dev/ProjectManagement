package com.egabi.eg.projectmanagement.model.entities.transactions;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "INVOICE_LINES")
public class InvoiceLine {
    @Id
    @Column(name = "INV_LINE_ID", nullable = false)
    private Long id;

    @Column(name = "LINE_ID")
    private Long lineId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_ID")
    private Invoice invoice;

    @Size(max = 500)
    @Column(name = "CUSTOMER_NAME", length = 500)
    private String customerName;

    @Size(max = 1000)
    @Column(name = "LINE_DESCRIPTION", length = 1000)
    private String lineDescription;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "AMOUNT_EGP")
    private Long amountEgp;

    @Column(name = "AMOUNT_WITH_VAT_EGP")
    private Long amountWithVatEgp;

    @Column(name = "VAT_AMOUNT")
    private Long vatAmount;

    @Column(name = "VAT_PERCENT")
    private Long vatPercent;

    @Size(max = 1000)
    @Column(name = "NOTES", length = 1000)
    private String notes;

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

    public Long getLineId() {
        return lineId;
    }

    public void setLineId(Long lineId) {
        this.lineId = lineId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLineDescription() {
        return lineDescription;
    }

    public void setLineDescription(String lineDescription) {
        this.lineDescription = lineDescription;
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

    public Long getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(Long vatAmount) {
        this.vatAmount = vatAmount;
    }

    public Long getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(Long vatPercent) {
        this.vatPercent = vatPercent;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
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