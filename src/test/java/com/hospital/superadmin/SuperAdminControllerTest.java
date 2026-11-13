package com.hospital.superadmin;

import com.hospital.controller.MediController;
import com.hospital.superadmin.controller.SuperAdminController;
import com.hospital.superadmin.service.SuperAdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class SuperAdminControllerTest {

    private MockMvc superAdminMockMvc;
    private MockMvc publicMockMvc;
    private SuperAdminService adminService;

    @BeforeEach
    public void setup() {
        adminService = new SuperAdminService();
        SuperAdminController superAdminController = new SuperAdminController(adminService);
        this.superAdminMockMvc = MockMvcBuilders.standaloneSetup(superAdminController).build();

        MediController mediController = new MediController();
        this.publicMockMvc = MockMvcBuilders.standaloneSetup(mediController).build();
    }

    @Test
    public void testPublicHomePageIntact() throws Exception {
        publicMockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testSuperAdminDashboard() throws Exception {
        superAdminMockMvc.perform(get("/superadmin"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/dashboard"))
                .andExpect(model().attributeExists("stats", "doctors", "recentPatients", "todayAppointments", "auditLogs"));
    }

    @Test
    public void testDoctorsPage() throws Exception {
        superAdminMockMvc.perform(get("/superadmin/doctors"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/doctors"))
                .andExpect(model().attributeExists("doctors", "departments"));
    }

    @Test
    public void testPatientsPage() throws Exception {
        superAdminMockMvc.perform(get("/superadmin/patients"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/patients"))
                .andExpect(model().attributeExists("patients", "doctors", "departments"));
    }

    @Test
    public void testAppointmentsPage() throws Exception {
        superAdminMockMvc.perform(get("/superadmin/appointments"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/appointments"))
                .andExpect(model().attributeExists("appointments", "doctors", "departments"));
    }

    @Test
    public void testDepartmentsPage() throws Exception {
        superAdminMockMvc.perform(get("/superadmin/departments"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/departments"))
                .andExpect(model().attributeExists("departments"));
    }

    @Test
    public void testWardsPage() throws Exception {
        superAdminMockMvc.perform(get("/superadmin/wards"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/wards"))
                .andExpect(model().attributeExists("beds", "stats"));
    }

    @Test
    public void testBillingPage() throws Exception {
        superAdminMockMvc.perform(get("/superadmin/billing"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/billing"))
                .andExpect(model().attributeExists("invoices", "stats"));
    }

    @Test
    public void testAuditLogsPage() throws Exception {
        superAdminMockMvc.perform(get("/superadmin/audit-logs"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/audit-logs"))
                .andExpect(model().attributeExists("auditLogs"));
    }

    @Test
    public void testSettingsPage() throws Exception {
        superAdminMockMvc.perform(get("/superadmin/settings"))
                .andExpect(status().isOk())
                .andExpect(view().name("superadmin/settings"))
                .andExpect(model().attributeExists("settings"));
    }

    @Test
    public void testAddDoctorPost() throws Exception {
        superAdminMockMvc.perform(post("/superadmin/doctors/add")
                        .param("name", "Dr. Alan Stone")
                        .param("specialty", "Consultant Neurologist")
                        .param("department", "Neurology & Neurosurgery")
                        .param("qualification", "MD, PhD")
                        .param("experienceYears", "14")
                        .param("consultationFee", "200.0")
                        .param("roomNo", "Suite 410")
                        .param("email", "a.stone@medionehealth.org")
                        .param("phone", "+1 555-909-1234")
                        .param("availableDays", "Mon, Wed")
                        .param("opdTimings", "10:00 AM - 02:00 PM"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/superadmin/doctors"));
    }
}
