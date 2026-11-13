package com.hospital.superadmin.model;

public class AuditLog {
    private String id;
    private String timestamp;
    private String actor;
    private String role;
    private String action;
    private String targetModule;
    private String ipAddress;
    private String severity; // "INFO", "WARNING", "CRITICAL", "SECURITY"
    private String details;

    public AuditLog() {}

    public AuditLog(String id, String timestamp, String actor, String role, String action, 
                    String targetModule, String ipAddress, String severity, String details) {
        this.id = id;
        this.timestamp = timestamp;
        this.actor = actor;
        this.role = role;
        this.action = action;
        this.targetModule = targetModule;
        this.ipAddress = ipAddress;
        this.severity = severity;
        this.details = details;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTimestamp() { return timestamp; }
    public void setTimestamp(String timestamp) { this.timestamp = timestamp; }

    public String getActor() { return actor; }
    public void setActor(String actor) { this.actor = actor; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getTargetModule() { return targetModule; }
    public void setTargetModule(String targetModule) { this.targetModule = targetModule; }

    public String getIpAddress() { return ipAddress; }
    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
