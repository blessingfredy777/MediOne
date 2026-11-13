package com.hospital.superadmin.service;

import com.hospital.superadmin.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class SuperAdminService {

    private final Map<String, Doctor> doctors = new ConcurrentHashMap<>();
    private final Map<String, Patient> patients = new ConcurrentHashMap<>();
    private final Map<String, Appointment> appointments = new ConcurrentHashMap<>();
    private final Map<String, Department> departments = new ConcurrentHashMap<>();
    private final Map<String, Bed> beds = new ConcurrentHashMap<>();
    private final Map<String, Invoice> invoices = new ConcurrentHashMap<>();
    private final List<AuditLog> auditLogs = Collections.synchronizedList(new ArrayList<>());
    private HospitalSettings settings = new HospitalSettings();

    public SuperAdminService() {
        seedInitialData();
    }

    private void seedInitialData() {
        seedDepartments();
        seedDoctors();
        seedPatients();
        seedAppointments();
        seedBeds();
        seedInvoices();
        seedAuditLogs();
    }

    private void seedDepartments() {
        Department d1 = new Department("DEP-01", "Cardiology & Vascular", "CARD", "Dr. David Ross, MD", 12, 45, 38, "Floor 3, East Wing", "Ext. 3010", "Active", 125000.0, "Comprehensive cardiac care, interventions, and diagnostics.", "bi-heart-pulse");
        Department d2 = new Department("DEP-02", "Neurology & Neurosurgery", "NEUR", "Dr. Sarah Jenkins, PhD", 9, 30, 24, "Floor 4, West Wing", "Ext. 4022", "Active", 140000.0, "Advanced neurological interventions, stroke management, and therapy.", "bi-activity");
        Department d3 = new Department("DEP-03", "Pediatrics & Child Health", "PEDI", "Dr. Emily Watson, MD", 14, 50, 41, "Floor 2, South Wing", "Ext. 2015", "Active", 95000.0, "Specialized neonatal and pediatric inpatient and outpatient care.", "bi-person-hearts");
        Department d4 = new Department("DEP-04", "Orthopedics & Joint Surgery", "ORTH", "Dr. Robert Taylor, MS", 10, 40, 35, "Floor 3, North Wing", "Ext. 3045", "Active", 110000.0, "Trauma, reconstructive surgery, sports medicine, and spine center.", "bi-person-walking");
        Department d5 = new Department("DEP-05", "Emergency & Critical Trauma", "EMER", "Dr. Rachel Adams, MD", 18, 25, 21, "Ground Floor, Zone A", "Ext. 1000", "Active", 180000.0, "Level-1 emergency response, resuscitation, and rapid triage.", "bi-hospital");
        Department d6 = new Department("DEP-06", "Oncology & Immunotherapy", "ONCO", "Dr. Michael Chen, MD", 8, 35, 29, "Floor 5, Tower B", "Ext. 5012", "Active", 160000.0, "Comprehensive cancer treatments, chemotherapy suites, and research.", "bi-shield-plus");
        Department d7 = new Department("DEP-07", "General Internal Medicine", "GENM", "Dr. James Wilson, MD", 15, 60, 48, "Floor 1, East Wing", "Ext. 1020", "Active", 85000.0, "Preventive checkups, diagnostic medicine, and metabolic disorders.", "bi-clipboard2-pulse");
        Department d8 = new Department("DEP-08", "Diagnostic Radiology & Imaging", "RAD", "Dr. Brian Miller, PhD", 7, 15, 8, "Basement Level 1", "Ext. 0820", "Active", 130000.0, "State-of-the-art 3T MRI, 128-slice CT, Digital X-Ray, and Sonography.", "bi-camera");

        for (Department d : Arrays.asList(d1, d2, d3, d4, d5, d6, d7, d8)) {
            departments.put(d.getId(), d);
        }
    }

    private void seedDoctors() {
        Doctor doc1 = new Doctor("DOC-101", "Dr. David Ross", "Senior Interventional Cardiologist", "Cardiology & Vascular", "MD, FACC, FSCAI", 18, "d.ross@medionehealth.org", "+1 (555) 234-5678", "Suite 302", "Active", "Mon, Wed, Fri", "09:00 AM - 02:00 PM", 180.0, 4.9, 3240, "images/doctor-1.jpg");
        Doctor doc2 = new Doctor("DOC-102", "Dr. Sarah Jenkins", "Consultant Neurosurgeon", "Neurology & Neurosurgery", "MD, FAANS, PhD", 15, "s.jenkins@medionehealth.org", "+1 (555) 345-6789", "Suite 415", "Active", "Tue, Thu, Sat", "10:00 AM - 03:00 PM", 220.0, 4.95, 2180, "images/doctor-2.jpg");
        Doctor doc3 = new Doctor("DOC-103", "Dr. Robert Taylor", "Orthopedic & Spine Surgeon", "Orthopedics & Joint Surgery", "MS (Ortho), MCh", 12, "r.taylor@medionehealth.org", "+1 (555) 456-7890", "Suite 340", "In Surgery", "Mon, Tue, Thu", "08:30 AM - 01:30 PM", 160.0, 4.8, 1950, "images/doctor-3.jpg");
        Doctor doc4 = new Doctor("DOC-104", "Dr. Emily Watson", "Pediatric Specialist & Neonatologist", "Pediatrics & Child Health", "MD (Peds), FAAP", 10, "e.watson@medionehealth.org", "+1 (555) 567-8901", "Suite 210", "Active", "Mon to Fri", "09:00 AM - 04:00 PM", 140.0, 4.9, 2890, "images/doctor-4.jpg");
        Doctor doc5 = new Doctor("DOC-105", "Dr. Michael Chen", "Senior Medical Oncologist", "Oncology & Immunotherapy", "MD, FACP, ESMO", 16, "m.chen@medionehealth.org", "+1 (555) 678-9012", "Suite 508", "Active", "Tue, Wed, Fri", "11:00 AM - 05:00 PM", 200.0, 4.88, 1620, "images/doctor-5.jpg");
        Doctor doc6 = new Doctor("DOC-106", "Dr. Rachel Adams", "Chief of Emergency Trauma", "Emergency & Critical Trauma", "MD, FACEP", 14, "r.adams@medionehealth.org", "+1 (555) 789-0123", "ER-Zone 1", "Active", "24/7 Shift Rotation", "12-Hour Trauma Shift", 190.0, 4.92, 4100, "images/doctor-6.jpg");
        Doctor doc7 = new Doctor("DOC-107", "Dr. James Wilson", "Chief Internist & Metabolic Care", "General Internal Medicine", "MD, FACP", 11, "j.wilson@medionehealth.org", "+1 (555) 890-1234", "Suite 112", "On Leave", "Mon, Wed, Thu", "09:00 AM - 03:00 PM", 130.0, 4.75, 2400, "images/doctor-1.jpg");
        Doctor doc8 = new Doctor("DOC-108", "Dr. Brian Miller", "Senior Consultant Radiologist", "Diagnostic Radiology & Imaging", "MD, FRCR", 13, "b.miller@medionehealth.org", "+1 (555) 901-2345", "Lab Rad-02", "Active", "Mon to Sat", "08:00 AM - 02:00 PM", 150.0, 4.85, 5200, "images/doctor-2.jpg");

        for (Doctor d : Arrays.asList(doc1, doc2, doc3, doc4, doc5, doc6, doc7, doc8)) {
            doctors.put(d.getId(), d);
        }
    }

    private void seedPatients() {
        Patient p1 = new Patient("PAT-001", "MRN-2026-8910", "Jane Smith", 48, "Female", "O+", "+1 (555) 111-2233", "jane.smith@example.com", "Acute Coronary Syndrome Post-Angioplasty", "2026-11-08", "Dr. David Ross", "Cardiology & Vascular", "ICU-Bed-04", "Inpatient", "John Smith (+1 555-111-2244)", "BlueCross Silver Shield");
        Patient p2 = new Patient("PAT-002", "MRN-2026-8911", "John Doe", 34, "Male", "A+", "+1 (555) 222-3344", "john.doe@example.com", "Lumbar Disc Herniation & Sciatica", "2026-11-10", "Dr. Robert Taylor", "Orthopedics & Joint Surgery", "ORTH-Bed-12", "Inpatient", "Mary Doe (+1 555-222-3355)", "Aetna Health Plus");
        Patient p3 = new Patient("PAT-003", "MRN-2026-8912", "Alice Johnson", 8, "Female", "B+", "+1 (555) 333-4455", "carlos.j@example.com", "Pediatric Bronchopneumonia", "2026-11-09", "Dr. Emily Watson", "Pediatrics & Child Health", "PEDI-Bed-06", "Inpatient", "Carlos Johnson (+1 555-333-4466)", "UnitedHealthcare CarePass");
        Patient p4 = new Patient("PAT-004", "MRN-2026-8913", "Robert Brown", 62, "Male", "B-", "+1 (555) 444-5566", "r.brown@example.com", "Subdural Hematoma Observation", "2026-11-11", "Dr. Sarah Jenkins", "Neurology & Neurosurgery", "ICU-Bed-02", "Inpatient", "Sarah Brown (+1 555-444-5577)", "Medicare Advantage Gold");
        Patient p5 = new Patient("PAT-005", "MRN-2026-8914", "Carol White", 53, "Female", "AB+", "+1 (555) 555-6677", "cwhite@example.com", "Stage II Breast Carcinoma Therapy", "2026-11-05", "Dr. Michael Chen", "Oncology & Immunotherapy", "ONCO-Bed-09", "Inpatient", "Henry White (+1 555-555-6688)", "Cigna Global Health");
        Patient p6 = new Patient("PAT-006", "MRN-2026-8915", "Daniel Lee", 29, "Male", "O-", "+1 (555) 666-7788", "dlee@example.com", "Motorcycle Trauma Poly-contusion", "2026-11-12", "Dr. Rachel Adams", "Emergency & Critical Trauma", "EMER-Bed-01", "Emergency", "Chloe Lee (+1 555-666-7799)", "State Farm Auto Medical");
        Patient p7 = new Patient("PAT-007", "MRN-2026-8916", "Mary Davis", 31, "Female", "A-", "+1 (555) 777-8899", "mary.d@example.com", "Uncontrolled Type-1 Diabetes Follow-up", "2026-11-12", "Dr. James Wilson", "General Internal Medicine", "OPD-Consult-03", "Outpatient", "Paul Davis (+1 555-777-8800)", "Kaiser Permanente Core");
        Patient p8 = new Patient("PAT-008", "MRN-2026-8917", "William Clark", 71, "Male", "O+", "+1 (555) 888-9900", "wclark@example.com", "Hypertensive Encephalopathy - Recovered", "2026-11-01", "Dr. David Ross", "Cardiology & Vascular", "Discharged", "Discharged", "Nancy Clark (+1 555-888-9911)", "Humana Choice PPO");

        for (Patient p : Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8)) {
            patients.put(p.getId(), p);
        }
    }

    private void seedAppointments() {
        Appointment a1 = new Appointment("APT-901", "Jane Smith", "MRN-2026-8910", "Dr. David Ross", "Cardiology & Vascular", "2026-11-12", "09:30 AM", "Follow-up", "In-Progress", "Urgent", "Room 302", "Post-angioplasty 48h ECG & biomarker review.");
        Appointment a2 = new Appointment("APT-902", "John Doe", "MRN-2026-8911", "Dr. Robert Taylor", "Orthopedics & Joint Surgery", "2026-11-12", "10:15 AM", "Surgery Prep", "Scheduled", "Normal", "Room 340", "Pre-op clearance for minimally invasive discectomy.");
        Appointment a3 = new Appointment("APT-903", "Alice Johnson", "MRN-2026-8912", "Dr. Emily Watson", "Pediatrics & Child Health", "2026-11-12", "11:00 AM", "General OPD", "Scheduled", "Normal", "Room 210", "Pediatric pulmonary auscultation and SpO2 check.");
        Appointment a4 = new Appointment("APT-904", "Daniel Lee", "MRN-2026-8916", "Dr. Rachel Adams", "Emergency & Critical Trauma", "2026-11-12", "08:00 AM", "Emergency", "Completed", "Emergency", "Trauma Bay 1", "Immediate FAST Ultrasound & cervical spine stabilization.");
        Appointment a5 = new Appointment("APT-905", "Mary Davis", "MRN-2026-8917", "Dr. James Wilson", "General Internal Medicine", "2026-11-12", "01:30 PM", "General OPD", "Scheduled", "Normal", "Room 112", "Insulin regimen adjustment and HbA1c review.");
        Appointment a6 = new Appointment("APT-906", "Robert Brown", "MRN-2026-8913", "Dr. Sarah Jenkins", "Neurology & Neurosurgery", "2026-11-12", "02:45 PM", "Diagnostics", "Scheduled", "Urgent", "MRI Suite 2", "Repeat cranial CT scan to evaluate resolution.");
        Appointment a7 = new Appointment("APT-907", "Carol White", "MRN-2026-8914", "Dr. Michael Chen", "Oncology & Immunotherapy", "2026-11-12", "03:30 PM", "Follow-up", "Scheduled", "Normal", "Room 508", "Cycle 3 immunotherapy infusion tolerance check.");
        Appointment a8 = new Appointment("APT-908", "William Clark", "MRN-2026-8917", "Dr. David Ross", "Cardiology & Vascular", "2026-11-11", "04:00 PM", "Follow-up", "Completed", "Low", "Room 302", "Discharge medication counseling and telemetry review.");

        for (Appointment a : Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8)) {
            appointments.put(a.getId(), a);
        }
    }

    private void seedBeds() {
        Bed b1 = new Bed("BED-01", "ICU-01", "Intensive Care Unit (ICU)", "ICU", "Floor 4", "Occupied", "Robert Brown", "MRN-2026-8913", "Dr. Sarah Jenkins", "2026-11-11", 1250.0);
        Bed b2 = new Bed("BED-02", "ICU-02", "Intensive Care Unit (ICU)", "ICU", "Floor 4", "Occupied", "Jane Smith", "MRN-2026-8910", "Dr. David Ross", "2026-11-08", 1250.0);
        Bed b3 = new Bed("BED-03", "ICU-03", "Intensive Care Unit (ICU)", "ICU", "Floor 4", "Available", null, null, null, null, 1250.0);
        Bed b4 = new Bed("BED-04", "ICU-04", "Intensive Care Unit (ICU)", "ICU", "Floor 4", "Cleaning", null, null, null, null, 1250.0);

        Bed b5 = new Bed("BED-05", "CARD-101", "Cardiology Step-Down Ward", "Semi-Private", "Floor 3", "Available", null, null, null, null, 680.0);
        Bed b6 = new Bed("BED-06", "CARD-102", "Cardiology Step-Down Ward", "Semi-Private", "Floor 3", "Occupied", "George Harris", "MRN-2026-8801", "Dr. David Ross", "2026-11-07", 680.0);

        Bed b7 = new Bed("BED-07", "ORTH-201", "Orthopedic Recovery Ward", "General Ward", "Floor 3", "Occupied", "John Doe", "MRN-2026-8911", "Dr. Robert Taylor", "2026-11-10", 350.0);
        Bed b8 = new Bed("BED-08", "ORTH-202", "Orthopedic Recovery Ward", "General Ward", "Floor 3", "Available", null, null, null, null, 350.0);

        Bed b9 = new Bed("BED-09", "PEDI-301", "Pediatric Inpatient Unit", "Semi-Private", "Floor 2", "Occupied", "Alice Johnson", "MRN-2026-8912", "Dr. Emily Watson", "2026-11-09", 520.0);
        Bed b10 = new Bed("BED-10", "PEDI-302", "Pediatric Inpatient Unit", "Semi-Private", "Floor 2", "Available", null, null, null, null, 520.0);

        Bed b11 = new Bed("BED-11", "EMER-01", "Emergency Trauma Bay", "Emergency Unit", "Ground Floor", "Occupied", "Daniel Lee", "MRN-2026-8916", "Dr. Rachel Adams", "2026-11-12", 850.0);
        Bed b12 = new Bed("BED-12", "EMER-02", "Emergency Trauma Bay", "Emergency Unit", "Ground Floor", "Available", null, null, null, null, 850.0);
        Bed b13 = new Bed("BED-13", "EMER-03", "Emergency Trauma Bay", "Emergency Unit", "Ground Floor", "Maintenance", null, null, null, null, 850.0);

        Bed b14 = new Bed("BED-14", "DLX-401", "Executive Deluxe Suite", "Deluxe Suite", "Floor 5", "Occupied", "Carol White", "MRN-2026-8914", "Dr. Michael Chen", "2026-11-05", 1600.0);
        Bed b15 = new Bed("BED-15", "DLX-402", "Executive Deluxe Suite", "Deluxe Suite", "Floor 5", "Available", null, null, null, null, 1600.0);

        for (Bed b : Arrays.asList(b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15)) {
            beds.put(b.getId(), b);
        }
    }

    private void seedInvoices() {
        Invoice inv1 = new Invoice("INV-8001", "MED-INV-2026-8001", "Jane Smith", "MRN-2026-8910", "Cardiology & Vascular", "Coronary Stent & 4-Day ICU Stay", 14250.0, 12000.0, 2250.0, "Claim Processing", "Health Insurance", "2026-11-10", "2026-11-25");
        Invoice inv2 = new Invoice("INV-8002", "MED-INV-2026-8002", "John Doe", "MRN-2026-8911", "Orthopedics & Joint Surgery", "Spine MRI, Consult & Physiotherapy", 3800.0, 3040.0, 760.0, "Paid", "Credit Card", "2026-11-11", "2026-11-26");
        Invoice inv3 = new Invoice("INV-8003", "MED-INV-2026-8003", "Alice Johnson", "MRN-2026-8912", "Pediatrics & Child Health", "Nebulization, Pediatric IV & Lab Tests", 1450.0, 1160.0, 290.0, "Paid", "UPI", "2026-11-10", "2026-11-20");
        Invoice inv4 = new Invoice("INV-8004", "MED-INV-2026-8004", "Robert Brown", "MRN-2026-8913", "Neurology & Neurosurgery", "Emergency Cranial CT & Trauma Care", 8900.0, 7500.0, 1400.0, "Pending", "Health Insurance", "2026-11-11", "2026-11-28");
        Invoice inv5 = new Invoice("INV-8005", "MED-INV-2026-8005", "Carol White", "MRN-2026-8914", "Oncology & Immunotherapy", "Cycle 3 Targeted Immunotherapy", 18500.0, 15000.0, 3500.0, "Partially Paid", "Wire Transfer", "2026-11-06", "2026-11-21");
        Invoice inv6 = new Invoice("INV-8006", "MED-INV-2026-8006", "Daniel Lee", "MRN-2026-8916", "Emergency & Critical Trauma", "Trauma Bay Resuscitation & Ultrasound", 4600.0, 3800.0, 800.0, "Pending", "Cash", "2026-11-12", "2026-11-27");
        Invoice inv7 = new Invoice("INV-8007", "MED-INV-2026-8007", "William Clark", "MRN-2026-8917", "Cardiology & Vascular", "Inpatient Telemetry & Discharge Pharmacy", 6200.0, 5200.0, 1000.0, "Paid", "Health Insurance", "2026-11-02", "2026-11-15");

        for (Invoice inv : Arrays.asList(inv1, inv2, inv3, inv4, inv5, inv6, inv7)) {
            invoices.put(inv.getId(), inv);
        }
    }

    private void seedAuditLogs() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        auditLogs.add(new AuditLog("LOG-001", now.minusMinutes(4).format(dtf), "Dr. Marcus Reed", "Super Admin", "BED_STATUS_UPDATE", "Ward Management", "192.168.1.10", "INFO", "Bed ICU-04 shifted to Cleaning protocol after discharge."));
        auditLogs.add(new AuditLog("LOG-002", now.minusMinutes(18).format(dtf), "System Gateway", "System", "BACKUP_COMPLETED", "Database & Backup", "127.0.0.1", "INFO", "Automated incremental cloud snapshot verified (Size: 4.82 GB)."));
        auditLogs.add(new AuditLog("LOG-003", now.minusMinutes(42).format(dtf), "Dr. Rachel Adams", "ER Chief", "EMERGENCY_ADMISSION", "Patient Care", "192.168.2.45", "WARNING", "Urgent trauma triage registered for Patient Daniel Lee (MRN-2026-8916)."));
        auditLogs.add(new AuditLog("LOG-004", now.minusHours(2).format(dtf), "Admin Security Daemon", "Security", "ROLE_PERMISSION_CHECK", "RBAC Engine", "10.0.0.1", "INFO", "Super Admin privileges authenticated for session UID-88910."));
        auditLogs.add(new AuditLog("LOG-005", now.minusHours(5).format(dtf), "Pharmacy Stock Daemon", "Inventory", "STOCK_THRESHOLD_ALERT", "Pharmacy", "10.0.0.1", "WARNING", "Epinephrine 1mg auto-injectors at 18 units (Threshold: 20 units)."));
        auditLogs.add(new AuditLog("LOG-006", now.minusHours(8).format(dtf), "Dr. David Ross", "HOD Cardiology", "PROCEDURE_LOGGED", "Cath Lab", "192.168.3.12", "INFO", "Coronary angioplasty completed with 0 intra-op complications."));
    }

    // --- Statistics Computation ---
    public HospitalStats getHospitalStats() {
        HospitalStats stats = new HospitalStats();

        stats.setTotalPatients(patients.size() + 1474);
        stats.setActiveInpatients(patients.values().stream().filter(p -> "Inpatient".equalsIgnoreCase(p.getStatus())).count());
        stats.setActiveOutpatients(patients.values().stream().filter(p -> "Outpatient".equalsIgnoreCase(p.getStatus())).count());

        stats.setTotalDoctors(doctors.size() + 70);
        stats.setOnDutyDoctors(doctors.values().stream().filter(d -> "Active".equalsIgnoreCase(d.getStatus()) || "In Surgery".equalsIgnoreCase(d.getStatus())).count() + 58);

        stats.setTodayAppointments(appointments.size() + 190);
        stats.setPendingAppointments(appointments.values().stream().filter(a -> "Scheduled".equalsIgnoreCase(a.getStatus())).count() + 66);
        stats.setCompletedAppointmentsToday(appointments.values().stream().filter(a -> "Completed".equalsIgnoreCase(a.getStatus())).count() + 82);

        int totalBedsCount = 300;
        int occupiedBedsCount = 254;
        stats.setTotalBeds(totalBedsCount);
        stats.setOccupiedBeds(occupiedBedsCount);
        stats.setAvailableBeds(totalBedsCount - occupiedBedsCount);
        stats.setIcuBedsTotal(35);
        stats.setIcuBedsOccupied(31);
        stats.setBedOccupancyPercentage(Math.round(((double) occupiedBedsCount / totalBedsCount) * 1000.0) / 10.0);

        stats.setMonthlyRevenue(384920.00);
        stats.setTodayRevenue(18450.00);
        stats.setEmergencyInflowCount(12);
        stats.setCriticalAlertsCount(3);

        stats.setMonthlyLabels(Arrays.asList("Jun", "Jul", "Aug", "Sep", "Oct", "Nov"));
        stats.setInpatientTrend(Arrays.asList(380, 420, 450, 410, 490, 530));
        stats.setOutpatientTrend(Arrays.asList(920, 1050, 1140, 1090, 1280, 1390));

        Map<String, Integer> deptDist = new LinkedHashMap<>();
        deptDist.put("Cardiology", 320);
        deptDist.put("Emergency", 380);
        deptDist.put("Pediatrics", 290);
        deptDist.put("Orthopedics", 240);
        deptDist.put("Neurology", 210);
        deptDist.put("Oncology", 180);
        stats.setDepartmentDistribution(deptDist);

        Map<String, Double> rev = new LinkedHashMap<>();
        rev.put("Inpatient & ICU", 165000.0);
        rev.put("Surgical Theatres", 95000.0);
        rev.put("Outpatient & OPD", 48000.0);
        rev.put("Diagnostic & Imaging", 42000.0);
        rev.put("Pharmacy & Meds", 34920.0);
        stats.setRevenueStreams(rev);

        return stats;
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors.values());
    }

    public Doctor getDoctorById(String id) {
        return doctors.get(id);
    }

    public void addDoctor(Doctor doctor) {
        if (doctor.getId() == null || doctor.getId().trim().isEmpty()) {
            doctor.setId("DOC-" + (100 + doctors.size() + 1));
        }
        if (doctor.getImage() == null || doctor.getImage().trim().isEmpty()) {
            doctor.setImage("images/doctor-1.jpg");
        }
        if (doctor.getRating() <= 0) doctor.setRating(4.9);
        if (doctor.getStatus() == null || doctor.getStatus().trim().isEmpty()) {
            doctor.setStatus("Active");
        }
        doctors.put(doctor.getId(), doctor);
        logAction("Super Admin", "DOCTOR_REGISTERED", "Doctors", "New doctor profile created: " + doctor.getName() + " (" + doctor.getSpecialty() + ")");
    }

    public void updateDoctorStatus(String id, String status) {
        Doctor doc = doctors.get(id);
        if (doc != null) {
            doc.setStatus(status);
            logAction("Super Admin", "DOCTOR_STATUS_CHANGED", "Doctors", "Doctor " + doc.getName() + " status updated to " + status);
        }
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    public Patient getPatientById(String id) {
        return patients.get(id);
    }

    public void addPatient(Patient patient) {
        if (patient.getId() == null || patient.getId().trim().isEmpty()) {
            patient.setId("PAT-0" + (patients.size() + 1));
        }
        if (patient.getMrn() == null || patient.getMrn().trim().isEmpty()) {
            patient.setMrn("MRN-2026-" + (8920 + patients.size()));
        }
        if (patient.getAdmissionDate() == null || patient.getAdmissionDate().trim().isEmpty()) {
            patient.setAdmissionDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        if (patient.getStatus() == null || patient.getStatus().trim().isEmpty()) {
            patient.setStatus("Inpatient");
        }
        patients.put(patient.getId(), patient);
        logAction("Super Admin", "PATIENT_ADMISSION", "Patients", "Patient " + patient.getName() + " (" + patient.getMrn() + ") admitted to " + patient.getDepartment());
    }

    public void dischargePatient(String id) {
        Patient p = patients.get(id);
        if (p != null) {
            p.setStatus("Discharged");
            p.setBedNumber("Discharged");
            logAction("Super Admin", "PATIENT_DISCHARGE", "Patients", "Patient " + p.getName() + " (" + p.getMrn() + ") successfully discharged.");
        }
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments.values());
    }

    public void addAppointment(Appointment appointment) {
        if (appointment.getId() == null || appointment.getId().trim().isEmpty()) {
            appointment.setId("APT-" + (910 + appointments.size()));
        }
        if (appointment.getStatus() == null || appointment.getStatus().trim().isEmpty()) {
            appointment.setStatus("Scheduled");
        }
        if (appointment.getPriority() == null || appointment.getPriority().trim().isEmpty()) {
            appointment.setPriority("Normal");
        }
        appointments.put(appointment.getId(), appointment);
        logAction("Super Admin", "APPOINTMENT_BOOKED", "Appointments", "Appointment " + appointment.getId() + " booked for " + appointment.getPatientName() + " with " + appointment.getDoctorName());
    }

    public void updateAppointmentStatus(String id, String status) {
        Appointment apt = appointments.get(id);
        if (apt != null) {
            apt.setStatus(status);
            logAction("Super Admin", "APPOINTMENT_STATUS_UPDATE", "Appointments", "Appointment " + apt.getId() + " status updated to " + status);
        }
    }

    public List<Department> getAllDepartments() {
        return new ArrayList<>(departments.values());
    }

    public void addDepartment(Department department) {
        if (department.getId() == null || department.getId().trim().isEmpty()) {
            department.setId("DEP-0" + (departments.size() + 1));
        }
        if (department.getStatus() == null || department.getStatus().trim().isEmpty()) {
            department.setStatus("Active");
        }
        if (department.getIconClass() == null || department.getIconClass().trim().isEmpty()) {
            department.setIconClass("bi-hospital");
        }
        departments.put(department.getId(), department);
        logAction("Super Admin", "DEPARTMENT_CREATED", "Departments", "Department " + department.getName() + " onboarded with HOD " + department.getHod());
    }

    public List<Bed> getAllBeds() {
        return new ArrayList<>(beds.values());
    }

    public void updateBedStatus(String id, String status, String patientName, String patientMrn, String doctor) {
        Bed bed = beds.get(id);
        if (bed != null) {
            bed.setStatus(status);
            if ("Occupied".equalsIgnoreCase(status)) {
                bed.setPatientName(patientName);
                bed.setPatientMrn(patientMrn);
                bed.setAssignedDoctor(doctor);
                bed.setAdmittedSince(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            } else if ("Available".equalsIgnoreCase(status) || "Cleaning".equalsIgnoreCase(status)) {
                bed.setPatientName(null);
                bed.setPatientMrn(null);
                bed.setAssignedDoctor(null);
                bed.setAdmittedSince(null);
            }
            logAction("Super Admin", "BED_STATUS_UPDATE", "Ward Management", "Bed " + bed.getBedNumber() + " status shifted to " + status);
        }
    }

    public List<Invoice> getAllInvoices() {
        return new ArrayList<>(invoices.values());
    }

    public void updateInvoiceStatus(String id, String status) {
        Invoice inv = invoices.get(id);
        if (inv != null) {
            inv.setPaymentStatus(status);
            logAction("Super Admin", "INVOICE_STATUS_UPDATE", "Billing", "Invoice " + inv.getInvoiceNumber() + " status marked as " + status);
        }
    }

    public List<AuditLog> getRecentAuditLogs() {
        List<AuditLog> copy = new ArrayList<>(auditLogs);
        Collections.reverse(copy);
        return copy;
    }

    public void logAction(String actor, String action, String targetModule, String details) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        AuditLog log = new AuditLog(
                "LOG-" + String.format("%03d", auditLogs.size() + 1),
                LocalDateTime.now().format(dtf),
                actor,
                "Super Admin",
                action,
                targetModule,
                "127.0.0.1",
                "INFO",
                details
        );
        auditLogs.add(log);
    }

    public HospitalSettings getSettings() {
        return settings;
    }

    public void updateSettings(HospitalSettings updated) {
        this.settings = updated;
        logAction("Super Admin", "SETTINGS_UPDATED", "System Config", "Global hospital profile and security configuration updated.");
    }
}
