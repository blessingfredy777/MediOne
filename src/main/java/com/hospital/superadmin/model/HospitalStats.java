package com.hospital.superadmin.model;

import java.util.List;
import java.util.Map;

public class HospitalStats {
    private long totalPatients;
    private long activeInpatients;
    private long activeOutpatients;
    private long totalDoctors;
    private long onDutyDoctors;
    private long todayAppointments;
    private long pendingAppointments;
    private long completedAppointmentsToday;
    private int totalBeds;
    private int occupiedBeds;
    private int availableBeds;
    private int icuBedsTotal;
    private int icuBedsOccupied;
    private double monthlyRevenue;
    private double todayRevenue;
    private int emergencyInflowCount;
    private int criticalAlertsCount;
    private double bedOccupancyPercentage;
    private List<String> monthlyLabels;
    private List<Integer> inpatientTrend;
    private List<Integer> outpatientTrend;
    private Map<String, Integer> departmentDistribution;
    private Map<String, Double> revenueStreams;

    public HospitalStats() {}

    public long getTotalPatients() { return totalPatients; }
    public void setTotalPatients(long totalPatients) { this.totalPatients = totalPatients; }

    public long getActiveInpatients() { return activeInpatients; }
    public void setActiveInpatients(long activeInpatients) { this.activeInpatients = activeInpatients; }

    public long getActiveOutpatients() { return activeOutpatients; }
    public void setActiveOutpatients(long activeOutpatients) { this.activeOutpatients = activeOutpatients; }

    public long getTotalDoctors() { return totalDoctors; }
    public void setTotalDoctors(long totalDoctors) { this.totalDoctors = totalDoctors; }

    public long getOnDutyDoctors() { return onDutyDoctors; }
    public void setOnDutyDoctors(long onDutyDoctors) { this.onDutyDoctors = onDutyDoctors; }

    public long getTodayAppointments() { return todayAppointments; }
    public void setTodayAppointments(long todayAppointments) { this.todayAppointments = todayAppointments; }

    public long getPendingAppointments() { return pendingAppointments; }
    public void setPendingAppointments(long pendingAppointments) { this.pendingAppointments = pendingAppointments; }

    public long getCompletedAppointmentsToday() { return completedAppointmentsToday; }
    public void setCompletedAppointmentsToday(long completedAppointmentsToday) { this.completedAppointmentsToday = completedAppointmentsToday; }

    public int getTotalBeds() { return totalBeds; }
    public void setTotalBeds(int totalBeds) { this.totalBeds = totalBeds; }

    public int getOccupiedBeds() { return occupiedBeds; }
    public void setOccupiedBeds(int occupiedBeds) { this.occupiedBeds = occupiedBeds; }

    public int getAvailableBeds() { return availableBeds; }
    public void setAvailableBeds(int availableBeds) { this.availableBeds = availableBeds; }

    public int getIcuBedsTotal() { return icuBedsTotal; }
    public void setIcuBedsTotal(int icuBedsTotal) { this.icuBedsTotal = icuBedsTotal; }

    public int getIcuBedsOccupied() { return icuBedsOccupied; }
    public void setIcuBedsOccupied(int icuBedsOccupied) { this.icuBedsOccupied = icuBedsOccupied; }

    public double getMonthlyRevenue() { return monthlyRevenue; }
    public void setMonthlyRevenue(double monthlyRevenue) { this.monthlyRevenue = monthlyRevenue; }

    public double getTodayRevenue() { return todayRevenue; }
    public void setTodayRevenue(double todayRevenue) { this.todayRevenue = todayRevenue; }

    public int getEmergencyInflowCount() { return emergencyInflowCount; }
    public void setEmergencyInflowCount(int emergencyInflowCount) { this.emergencyInflowCount = emergencyInflowCount; }

    public int getCriticalAlertsCount() { return criticalAlertsCount; }
    public void setCriticalAlertsCount(int criticalAlertsCount) { this.criticalAlertsCount = criticalAlertsCount; }

    public double getBedOccupancyPercentage() { return bedOccupancyPercentage; }
    public void setBedOccupancyPercentage(double bedOccupancyPercentage) { this.bedOccupancyPercentage = bedOccupancyPercentage; }

    public List<String> getMonthlyLabels() { return monthlyLabels; }
    public void setMonthlyLabels(List<String> monthlyLabels) { this.monthlyLabels = monthlyLabels; }

    public List<Integer> getInpatientTrend() { return inpatientTrend; }
    public void setInpatientTrend(List<Integer> inpatientTrend) { this.inpatientTrend = inpatientTrend; }

    public List<Integer> getOutpatientTrend() { return outpatientTrend; }
    public void setOutpatientTrend(List<Integer> outpatientTrend) { this.outpatientTrend = outpatientTrend; }

    public Map<String, Integer> getDepartmentDistribution() { return departmentDistribution; }
    public void setDepartmentDistribution(Map<String, Integer> departmentDistribution) { this.departmentDistribution = departmentDistribution; }

    public Map<String, Double> getRevenueStreams() { return revenueStreams; }
    public void setRevenueStreams(Map<String, Double> revenueStreams) { this.revenueStreams = revenueStreams; }
}
