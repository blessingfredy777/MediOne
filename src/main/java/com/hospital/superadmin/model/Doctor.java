package com.hospital.superadmin.model;

public class Doctor {
    private String id;
    private String name;
    private String specialty;
    private String department;
    private String qualification;
    private int experienceYears;
    private String email;
    private String phone;
    private String roomNo;
    private String status; // "Active", "On Leave", "In Surgery", "Inactive"
    private String availableDays;
    private String opdTimings;
    private double consultationFee;
    private double rating;
    private int totalPatientsTreated;
    private String image;

    public Doctor() {}

    public Doctor(String id, String name, String specialty, String department, String qualification, 
                  int experienceYears, String email, String phone, String roomNo, String status, 
                  String availableDays, String opdTimings, double consultationFee, double rating, 
                  int totalPatientsTreated, String image) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.department = department;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.email = email;
        this.phone = phone;
        this.roomNo = roomNo;
        this.status = status;
        this.availableDays = availableDays;
        this.opdTimings = opdTimings;
        this.consultationFee = consultationFee;
        this.rating = rating;
        this.totalPatientsTreated = totalPatientsTreated;
        this.image = image;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getQualification() { return qualification; }
    public void setQualification(String qualification) { this.qualification = qualification; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getRoomNo() { return roomNo; }
    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAvailableDays() { return availableDays; }
    public void setAvailableDays(String availableDays) { this.availableDays = availableDays; }

    public String getOpdTimings() { return opdTimings; }
    public void setOpdTimings(String opdTimings) { this.opdTimings = opdTimings; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }

    public int getTotalPatientsTreated() { return totalPatientsTreated; }
    public void setTotalPatientsTreated(int totalPatientsTreated) { this.totalPatientsTreated = totalPatientsTreated; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}
