package com.hospital.superadmin.model;

public class Patient {
    private String id;
    private String mrn; // Medical Record Number, e.g., "MRN-2026-891"
    private String name;
    private int age;
    private String gender;
    private String bloodGroup;
    private String phone;
    private String email;
    private String condition;
    private String admissionDate;
    private String assignedDoctor;
    private String department;
    private String bedNumber;
    private String status; // "Inpatient", "Outpatient", "Discharged", "Emergency"
    private String emergencyContact;
    private String insuranceProvider;

    public Patient() {}

    public Patient(String id, String mrn, String name, int age, String gender, String bloodGroup, 
                   String phone, String email, String condition, String admissionDate, 
                   String assignedDoctor, String department, String bedNumber, String status, 
                   String emergencyContact, String insuranceProvider) {
        this.id = id;
        this.mrn = mrn;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.phone = phone;
        this.email = email;
        this.condition = condition;
        this.admissionDate = admissionDate;
        this.assignedDoctor = assignedDoctor;
        this.department = department;
        this.bedNumber = bedNumber;
        this.status = status;
        this.emergencyContact = emergencyContact;
        this.insuranceProvider = insuranceProvider;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMrn() { return mrn; }
    public void setMrn(String mrn) { this.mrn = mrn; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }

    public String getAssignedDoctor() { return assignedDoctor; }
    public void setAssignedDoctor(String assignedDoctor) { this.assignedDoctor = assignedDoctor; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getBedNumber() { return bedNumber; }
    public void setBedNumber(String bedNumber) { this.bedNumber = bedNumber; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public String getInsuranceProvider() { return insuranceProvider; }
    public void setInsuranceProvider(String insuranceProvider) { this.insuranceProvider = insuranceProvider; }
}
