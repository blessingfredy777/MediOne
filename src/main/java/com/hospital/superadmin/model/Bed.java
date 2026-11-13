package com.hospital.superadmin.model;

public class Bed {
    private String id;
    private String bedNumber;
    private String wardName;
    private String wardType; // "ICU", "General Ward", "Semi-Private", "Deluxe Suite", "Emergency Unit"
    private String floor;
    private String status; // "Available", "Occupied", "Cleaning", "Maintenance"
    private String patientName;
    private String patientMrn;
    private String assignedDoctor;
    private String admittedSince;
    private double dailyRate;

    public Bed() {}

    public Bed(String id, String bedNumber, String wardName, String wardType, String floor, 
               String status, String patientName, String patientMrn, String assignedDoctor, 
               String admittedSince, double dailyRate) {
        this.id = id;
        this.bedNumber = bedNumber;
        this.wardName = wardName;
        this.wardType = wardType;
        this.floor = floor;
        this.status = status;
        this.patientName = patientName;
        this.patientMrn = patientMrn;
        this.assignedDoctor = assignedDoctor;
        this.admittedSince = admittedSince;
        this.dailyRate = dailyRate;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBedNumber() { return bedNumber; }
    public void setBedNumber(String bedNumber) { this.bedNumber = bedNumber; }

    public String getWardName() { return wardName; }
    public void setWardName(String wardName) { this.wardName = wardName; }

    public String getWardType() { return wardType; }
    public void setWardType(String wardType) { this.wardType = wardType; }

    public String getFloor() { return floor; }
    public void setFloor(String floor) { this.floor = floor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getPatientMrn() { return patientMrn; }
    public void setPatientMrn(String patientMrn) { this.patientMrn = patientMrn; }

    public String getAssignedDoctor() { return assignedDoctor; }
    public void setAssignedDoctor(String assignedDoctor) { this.assignedDoctor = assignedDoctor; }

    public String getAdmittedSince() { return admittedSince; }
    public void setAdmittedSince(String admittedSince) { this.admittedSince = admittedSince; }

    public double getDailyRate() { return dailyRate; }
    public void setDailyRate(double dailyRate) { this.dailyRate = dailyRate; }
}
