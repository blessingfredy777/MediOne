package com.hospital.superadmin.model;

public class Invoice {
    private String id;
    private String invoiceNumber;
    private String patientName;
    private String patientMrn;
    private String department;
    private String services;
    private double totalAmount;
    private double insuranceCovered;
    private double patientPayable;
    private String paymentStatus; // "Paid", "Pending", "Partially Paid", "Claim Processing"
    private String paymentMethod; // "Health Insurance", "Credit Card", "Wire Transfer", "Cash", "UPI"
    private String dateIssued;
    private String dueDate;

    public Invoice() {}

    public Invoice(String id, String invoiceNumber, String patientName, String patientMrn, 
                   String department, String services, double totalAmount, double insuranceCovered, 
                   double patientPayable, String paymentStatus, String paymentMethod, 
                   String dateIssued, String dueDate) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.patientName = patientName;
        this.patientMrn = patientMrn;
        this.department = department;
        this.services = services;
        this.totalAmount = totalAmount;
        this.insuranceCovered = insuranceCovered;
        this.patientPayable = patientPayable;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.dateIssued = dateIssued;
        this.dueDate = dueDate;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getInvoiceNumber() { return invoiceNumber; }
    public void setInvoiceNumber(String invoiceNumber) { this.invoiceNumber = invoiceNumber; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getPatientMrn() { return patientMrn; }
    public void setPatientMrn(String patientMrn) { this.patientMrn = patientMrn; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getInsuranceCovered() { return insuranceCovered; }
    public void setInsuranceCovered(double insuranceCovered) { this.insuranceCovered = insuranceCovered; }

    public double getPatientPayable() { return patientPayable; }
    public void setPatientPayable(double patientPayable) { this.patientPayable = patientPayable; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getDateIssued() { return dateIssued; }
    public void setDateIssued(String dateIssued) { this.dateIssued = dateIssued; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }
}
