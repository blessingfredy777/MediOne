package com.hospital.superadmin.model;

public class Department {
    private String id;
    private String name;
    private String code;
    private String hod; // Head of Department
    private int totalDoctors;
    private int totalBeds;
    private int occupiedBeds;
    private String floor;
    private String extension;
    private String status; // "Active", "Full Capacity", "Under Renovation"
    private double monthlyBudget;
    private String description;
    private String iconClass;

    public Department() {}

    public Department(String id, String name, String code, String hod, int totalDoctors, 
                      int totalBeds, int occupiedBeds, String floor, String extension, 
                      String status, double monthlyBudget, String description, String iconClass) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.hod = hod;
        this.totalDoctors = totalDoctors;
        this.totalBeds = totalBeds;
        this.occupiedBeds = occupiedBeds;
        this.floor = floor;
        this.extension = extension;
        this.status = status;
        this.monthlyBudget = monthlyBudget;
        this.description = description;
        this.iconClass = iconClass;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getHod() { return hod; }
    public void setHod(String hod) { this.hod = hod; }

    public int getTotalDoctors() { return totalDoctors; }
    public void setTotalDoctors(int totalDoctors) { this.totalDoctors = totalDoctors; }

    public int getTotalBeds() { return totalBeds; }
    public void setTotalBeds(int totalBeds) { this.totalBeds = totalBeds; }

    public int getOccupiedBeds() { return occupiedBeds; }
    public void setOccupiedBeds(int occupiedBeds) { this.occupiedBeds = occupiedBeds; }

    public String getFloor() { return floor; }
    public void setFloor(String floor) { this.floor = floor; }

    public String getExtension() { return extension; }
    public void setExtension(String extension) { this.extension = extension; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getMonthlyBudget() { return monthlyBudget; }
    public void setMonthlyBudget(double monthlyBudget) { this.monthlyBudget = monthlyBudget; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIconClass() { return iconClass; }
    public void setIconClass(String iconClass) { this.iconClass = iconClass; }

    public int getOccupancyRate() {
        if (totalBeds == 0) return 0;
        return (int) Math.round(((double) occupiedBeds / totalBeds) * 100);
    }
}
