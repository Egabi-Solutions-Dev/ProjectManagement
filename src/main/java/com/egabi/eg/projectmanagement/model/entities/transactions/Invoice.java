package com.egabi.eg.projectmanagement.model.entities.transactions;

import com.egabi.eg.projectmanagement.model.entities.lkp.LkpStatus;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "INVOICES")
public class Invoice {
    @Id
    @Column(name = "INVOICE_ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "INVOICE_NUMBER", length = 100)
    private String invoiceNumber;

    @Column(name = "INVOICE_DATE")
    private LocalDate invoiceDate;

    @Column(name = "INVOICE_CREATION_DATE")
    private LocalDate invoiceCreationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MILESTONE_ID")
    private ContractMilestone milestone;

    @Size(max = 500)
    @Column(name = "CUSTOMER_NAME", length = 500)
    private String customerName;

    @Column(name = "TOAL_AMOUNT")
    private Long toalAmount;

    @Column(name = "TOTAL_AMOUNT_EGP")
    private Long totalAmountEgp;

    @Column(name = "TOTAL_AMOUNT_WITH_VAT_EGP")
    private Long totalAmountWithVatEgp;

    @Column(name = "CURRENCY_ID")
    private Long currencyId;

    @Column(name = "EXCHANGE_RATE")
    private Long exchangeRate;

    @Size(max = 4000)
    @Column(name = "NOTES", length = 4000)
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INVOICE_STATUS")
    private LkpStatus invoiceStatus;

    @Column(name = "VAT_PERCENT")
    private Long vatPercent;

    @Column(name = "TOTAL_VAT_AMOUNT")
    private Long totalVatAmount;

    @Column(name = "EXPECTED_COLLECTION_DATE")
    private LocalDate expectedCollectionDate;

    @Column(name = "COLLECTION_DATE")
    private LocalDate collectionDate;

    @Column(name = "PM_USER")
    private Long pmUser;

    @Column(name = "SECTORE_MANAGER_USER")
    private Long sectoreManagerUser;

    @Column(name = "TOTAL_AMOUNT_USD")
    private Long totalAmountUsd;

    @Column(name = "TOTAL_AMOUNT_WITH_VAT_USD")
    private Long totalAmountWithVatUsd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public LocalDate getInvoiceCreationDate() {
        return invoiceCreationDate;
    }

    public void setInvoiceCreationDate(LocalDate invoiceCreationDate) {
        this.invoiceCreationDate = invoiceCreationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ContractMilestone getMilestone() {
        return milestone;
    }

    public void setMilestone(ContractMilestone milestone) {
        this.milestone = milestone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getToalAmount() {
        return toalAmount;
    }

    public void setToalAmount(Long toalAmount) {
        this.toalAmount = toalAmount;
    }

    public Long getTotalAmountEgp() {
        return totalAmountEgp;
    }

    public void setTotalAmountEgp(Long totalAmountEgp) {
        this.totalAmountEgp = totalAmountEgp;
    }

    public Long getTotalAmountWithVatEgp() {
        return totalAmountWithVatEgp;
    }

    public void setTotalAmountWithVatEgp(Long totalAmountWithVatEgp) {
        this.totalAmountWithVatEgp = totalAmountWithVatEgp;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Long getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Long exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LkpStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(LkpStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Long getVatPercent() {
        return vatPercent;
    }

    public void setVatPercent(Long vatPercent) {
        this.vatPercent = vatPercent;
    }

    public Long getTotalVatAmount() {
        return totalVatAmount;
    }

    public void setTotalVatAmount(Long totalVatAmount) {
        this.totalVatAmount = totalVatAmount;
    }

    public LocalDate getExpectedCollectionDate() {
        return expectedCollectionDate;
    }

    public void setExpectedCollectionDate(LocalDate expectedCollectionDate) {
        this.expectedCollectionDate = expectedCollectionDate;
    }

    public LocalDate getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(LocalDate collectionDate) {
        this.collectionDate = collectionDate;
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

    public Long getTotalAmountUsd() {
        return totalAmountUsd;
    }

    public void setTotalAmountUsd(Long totalAmountUsd) {
        this.totalAmountUsd = totalAmountUsd;
    }

    public Long getTotalAmountWithVatUsd() {
        return totalAmountWithVatUsd;
    }

    public void setTotalAmountWithVatUsd(Long totalAmountWithVatUsd) {
        this.totalAmountWithVatUsd = totalAmountWithVatUsd;
    }

}