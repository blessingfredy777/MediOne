package com.hospital.superadmin.model;

public class Appointment {
    private String id;
    private String patientName;
    private String patientMrn;
    private String doctorName;
    private String department;
    private String appointmentDate;
    private String appointmentTime;
    private String type; // "General OPD", "Emergency", "Follow-up", "Surgery Prep", "Diagnostics"
    private String status; // "Scheduled", "In-Progress", "Completed", "Cancelled"
    private String priority; // "Low", "Normal", "Urgent", "Emergency"
    private String roomNo;
    private String notes;

    public Appointment() {}

    public Appointment(String id, String patientName, String patientMrn, String doctorName, 
                       String department, String appointmentDate, String appointmentTime, 
                       String type, String status, String priority, String roomNo, String notes) {
        this.id = id;
        this.patientName = patientName;
        this.patientMrn = patientMrn;
        this.doctorName = doctorName;
        this.department = department;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.type = type;
        this.status = status;
        this.priority = priority;
        this.roomNo = roomNo;
        this.notes = notes;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getPatientMrn() { return patientMrn; }
    public void setPatientMrn(String patientMrn) { this.patientMrn = patientMrn; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(String appointmentDate) { this.appointmentDate = appointmentDate; }

    public String getAppointmentTime() { return appointmentTime; }
    public void setAppointmentTime(String appointmentTime) { this.appointmentTime = appointmentTime; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getRoomNo() { return roomNo; }
    public void setRoomNo(String roomNo) { this.roomNo = roomNo; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
