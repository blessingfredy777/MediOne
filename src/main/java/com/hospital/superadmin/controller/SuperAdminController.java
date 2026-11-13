package com.hospital.superadmin.controller;

import com.hospital.superadmin.model.*;
import com.hospital.superadmin.service.SuperAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/superadmin")
public class SuperAdminController {

    private final SuperAdminService adminService;

    public SuperAdminController(SuperAdminService adminService) {
        this.adminService = adminService;
    }

    // --- Dashboard Overview ---
    @GetMapping({"", "/"})
    public String dashboard(Model model) {
        HospitalStats stats = adminService.getHospitalStats();
        List<Doctor> doctors = adminService.getAllDoctors();
        List<Patient> patients = adminService.getAllPatients();
        List<Appointment> appointments = adminService.getAllAppointments();
        List<AuditLog> auditLogs = adminService.getRecentAuditLogs();
        List<Department> departments = adminService.getAllDepartments();
        List<Bed> beds = adminService.getAllBeds();

        model.addAttribute("activePage", "dashboard");
        model.addAttribute("stats", stats);
        model.addAttribute("doctors", doctors);
        model.addAttribute("recentPatients", patients.stream().limit(6).collect(Collectors.toList()));
        model.addAttribute("todayAppointments", appointments.stream().limit(6).collect(Collectors.toList()));
        model.addAttribute("auditLogs", auditLogs.stream().limit(5).collect(Collectors.toList()));
        model.addAttribute("departments", departments);
        model.addAttribute("beds", beds);
        return "superadmin/dashboard";
    }

    // --- Doctor Management ---
    @GetMapping("/doctors")
    public String doctors(@RequestParam(value = "dept", required = false) String dept,
                          @RequestParam(value = "search", required = false) String search,
                          Model model) {
        List<Doctor> list = adminService.getAllDoctors();
        if (dept != null && !dept.trim().isEmpty() && !"All".equalsIgnoreCase(dept)) {
            list = list.stream().filter(d -> d.getDepartment().equalsIgnoreCase(dept)).collect(Collectors.toList());
        }
        if (search != null && !search.trim().isEmpty()) {
            String q = search.toLowerCase();
            list = list.stream().filter(d -> d.getName().toLowerCase().contains(q) || 
                                             d.getSpecialty().toLowerCase().contains(q) || 
                                             d.getDepartment().toLowerCase().contains(q)).collect(Collectors.toList());
        }

        model.addAttribute("activePage", "doctors");
        model.addAttribute("doctors", list);
        model.addAttribute("departments", adminService.getAllDepartments());
        model.addAttribute("selectedDept", dept != null ? dept : "All");
        model.addAttribute("searchTerm", search != null ? search : "");
        return "superadmin/doctors";
    }

    @PostMapping("/doctors/add")
    public String addDoctor(@ModelAttribute Doctor doctor, RedirectAttributes redirectAttributes) {
        adminService.addDoctor(doctor);
        redirectAttributes.addFlashAttribute("successMessage", "Doctor " + doctor.getName() + " registered successfully!");
        return "redirect:/superadmin/doctors";
    }

    @PostMapping("/doctors/{id}/status")
    public String updateDoctorStatus(@PathVariable("id") String id, 
                                     @RequestParam("status") String status, 
                                     RedirectAttributes redirectAttributes) {
        adminService.updateDoctorStatus(id, status);
        redirectAttributes.addFlashAttribute("successMessage", "Doctor status updated to " + status);
        return "redirect:/superadmin/doctors";
    }

    // --- Patient Management ---
    @GetMapping("/patients")
    public String patients(@RequestParam(value = "status", required = false) String status,
                           @RequestParam(value = "search", required = false) String search,
                           Model model) {
        List<Patient> list = adminService.getAllPatients();
        if (status != null && !status.trim().isEmpty() && !"All".equalsIgnoreCase(status)) {
            list = list.stream().filter(p -> p.getStatus().equalsIgnoreCase(status)).collect(Collectors.toList());
        }
        if (search != null && !search.trim().isEmpty()) {
            String q = search.toLowerCase();
            list = list.stream().filter(p -> p.getName().toLowerCase().contains(q) || 
                                             p.getMrn().toLowerCase().contains(q) || 
                                             p.getCondition().toLowerCase().contains(q)).collect(Collectors.toList());
        }

        model.addAttribute("activePage", "patients");
        model.addAttribute("patients", list);
        model.addAttribute("departments", adminService.getAllDepartments());
        model.addAttribute("doctors", adminService.getAllDoctors());
        model.addAttribute("selectedStatus", status != null ? status : "All");
        model.addAttribute("searchTerm", search != null ? search : "");
        return "superadmin/patients";
    }

    @PostMapping("/patients/add")
    public String addPatient(@ModelAttribute Patient patient, RedirectAttributes redirectAttributes) {
        adminService.addPatient(patient);
        redirectAttributes.addFlashAttribute("successMessage", "Patient " + patient.getName() + " (" + patient.getMrn() + ") admitted successfully!");
        return "redirect:/superadmin/patients";
    }

    @PostMapping("/patients/{id}/discharge")
    public String dischargePatient(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        adminService.dischargePatient(id);
        redirectAttributes.addFlashAttribute("successMessage", "Patient discharge summary completed successfully.");
        return "redirect:/superadmin/patients";
    }

    // --- Appointment Management ---
    @GetMapping("/appointments")
    public String appointments(@RequestParam(value = "status", required = false) String status,
                               @RequestParam(value = "search", required = false) String search,
                               Model model) {
        List<Appointment> list = adminService.getAllAppointments();
        if (status != null && !status.trim().isEmpty() && !"All".equalsIgnoreCase(status)) {
            list = list.stream().filter(a -> a.getStatus().equalsIgnoreCase(status)).collect(Collectors.toList());
        }
        if (search != null && !search.trim().isEmpty()) {
            String q = search.toLowerCase();
            list = list.stream().filter(a -> a.getPatientName().toLowerCase().contains(q) || 
                                             a.getDoctorName().toLowerCase().contains(q) || 
                                             a.getDepartment().toLowerCase().contains(q)).collect(Collectors.toList());
        }

        model.addAttribute("activePage", "appointments");
        model.addAttribute("appointments", list);
        model.addAttribute("departments", adminService.getAllDepartments());
        model.addAttribute("doctors", adminService.getAllDoctors());
        model.addAttribute("selectedStatus", status != null ? status : "All");
        model.addAttribute("searchTerm", search != null ? search : "");
        return "superadmin/appointments";
    }

    @PostMapping("/appointments/add")
    public String addAppointment(@ModelAttribute Appointment appointment, RedirectAttributes redirectAttributes) {
        adminService.addAppointment(appointment);
        redirectAttributes.addFlashAttribute("successMessage", "Appointment booked for " + appointment.getPatientName() + " successfully!");
        return "redirect:/superadmin/appointments";
    }

    @PostMapping("/appointments/{id}/status")
    public String updateAppointmentStatus(@PathVariable("id") String id, 
                                          @RequestParam("status") String status, 
                                          RedirectAttributes redirectAttributes) {
        adminService.updateAppointmentStatus(id, status);
        redirectAttributes.addFlashAttribute("successMessage", "Appointment status updated to " + status);
        return "redirect:/superadmin/appointments";
    }

    // --- Department Management ---
    @GetMapping("/departments")
    public String departments(Model model) {
        model.addAttribute("activePage", "departments");
        model.addAttribute("departments", adminService.getAllDepartments());
        return "superadmin/departments";
    }

    @PostMapping("/departments/add")
    public String addDepartment(@ModelAttribute Department department, RedirectAttributes redirectAttributes) {
        adminService.addDepartment(department);
        redirectAttributes.addFlashAttribute("successMessage", "Department " + department.getName() + " onboarded successfully!");
        return "redirect:/superadmin/departments";
    }

    // --- Ward & Bed Management ---
    @GetMapping("/wards")
    public String wards(Model model) {
        model.addAttribute("activePage", "wards");
        model.addAttribute("beds", adminService.getAllBeds());
        model.addAttribute("stats", adminService.getHospitalStats());
        return "superadmin/wards";
    }

    @PostMapping("/beds/{id}/status")
    public String updateBedStatus(@PathVariable("id") String id,
                                  @RequestParam("status") String status,
                                  @RequestParam(value = "patientName", required = false) String patientName,
                                  @RequestParam(value = "patientMrn", required = false) String patientMrn,
                                  @RequestParam(value = "doctor", required = false) String doctor,
                                  RedirectAttributes redirectAttributes) {
        adminService.updateBedStatus(id, status, patientName, patientMrn, doctor);
        redirectAttributes.addFlashAttribute("successMessage", "Bed status updated successfully!");
        return "redirect:/superadmin/wards";
    }

    // --- Billing & Financials ---
    @GetMapping("/billing")
    public String billing(Model model) {
        model.addAttribute("activePage", "billing");
        model.addAttribute("invoices", adminService.getAllInvoices());
        model.addAttribute("stats", adminService.getHospitalStats());
        return "superadmin/billing";
    }

    @PostMapping("/billing/{id}/status")
    public String updateInvoiceStatus(@PathVariable("id") String id, 
                                      @RequestParam("status") String status, 
                                      RedirectAttributes redirectAttributes) {
        adminService.updateInvoiceStatus(id, status);
        redirectAttributes.addFlashAttribute("successMessage", "Invoice status marked as " + status);
        return "redirect:/superadmin/billing";
    }

    // --- Governance & Audit Logs ---
    @GetMapping("/audit-logs")
    public String auditLogs(Model model) {
        model.addAttribute("activePage", "audit-logs");
        model.addAttribute("auditLogs", adminService.getRecentAuditLogs());
        return "superadmin/audit-logs";
    }

    // --- System Settings ---
    @GetMapping("/settings")
    public String settings(Model model) {
        model.addAttribute("activePage", "settings");
        model.addAttribute("settings", adminService.getSettings());
        return "superadmin/settings";
    }

    @PostMapping("/settings/update")
    public String updateSettings(@ModelAttribute HospitalSettings settings, RedirectAttributes redirectAttributes) {
        adminService.updateSettings(settings);
        redirectAttributes.addFlashAttribute("successMessage", "Hospital system settings updated successfully!");
        return "redirect:/superadmin/settings";
    }
}
