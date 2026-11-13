package com.hospital.superadmin.model;

public class HospitalSettings {
    private String hospitalName;
    private String registrationNumber;
    private String emergencyHelpline;
    private String primaryEmail;
    private String address;
    private String city;
    private String postalCode;
    private String country;
    private String defaultCurrency;
    private int bedCapacityLimit;
    private boolean maintenanceMode;
    private boolean autoBackupEnabled;
    private String backupFrequency; // "Hourly", "Daily", "Weekly"
    private boolean smsAlertsEnabled;
    private boolean emailAlertsEnabled;
    private boolean twoFactorAuthRequired;
    private int sessionTimeoutMinutes;

    public HospitalSettings() {
        this.hospitalName = "MediOne Multispeciality Hospital & Research Center";
        this.registrationNumber = "MED-HOSP-2024-9041";
        this.emergencyHelpline = "+1 (800) 555-0199";
        this.primaryEmail = "superadmin@medionehealth.org";
        this.address = "742 Evergreen Healthcare Blvd, Suite 400";
        this.city = "Metropolis";
        this.postalCode = "10001";
        this.country = "United States";
        this.defaultCurrency = "USD ($)";
        this.bedCapacityLimit = 350;
        this.maintenanceMode = false;
        this.autoBackupEnabled = true;
        this.backupFrequency = "Daily at 02:00 AM";
        this.smsAlertsEnabled = true;
        this.emailAlertsEnabled = true;
        this.twoFactorAuthRequired = true;
        this.sessionTimeoutMinutes = 30;
    }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public String getEmergencyHelpline() { return emergencyHelpline; }
    public void setEmergencyHelpline(String emergencyHelpline) { this.emergencyHelpline = emergencyHelpline; }

    public String getPrimaryEmail() { return primaryEmail; }
    public void setPrimaryEmail(String primaryEmail) { this.primaryEmail = primaryEmail; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getDefaultCurrency() { return defaultCurrency; }
    public void setDefaultCurrency(String defaultCurrency) { this.defaultCurrency = defaultCurrency; }

    public int getBedCapacityLimit() { return bedCapacityLimit; }
    public void setBedCapacityLimit(int bedCapacityLimit) { this.bedCapacityLimit = bedCapacityLimit; }

    public boolean isMaintenanceMode() { return maintenanceMode; }
    public void setMaintenanceMode(boolean maintenanceMode) { this.maintenanceMode = maintenanceMode; }

    public boolean isAutoBackupEnabled() { return autoBackupEnabled; }
    public void setAutoBackupEnabled(boolean autoBackupEnabled) { this.autoBackupEnabled = autoBackupEnabled; }

    public String getBackupFrequency() { return backupFrequency; }
    public void setBackupFrequency(String backupFrequency) { this.backupFrequency = backupFrequency; }

    public boolean isSmsAlertsEnabled() { return smsAlertsEnabled; }
    public void setSmsAlertsEnabled(boolean smsAlertsEnabled) { this.smsAlertsEnabled = smsAlertsEnabled; }

    public boolean isEmailAlertsEnabled() { return emailAlertsEnabled; }
    public void setEmailAlertsEnabled(boolean emailAlertsEnabled) { this.emailAlertsEnabled = emailAlertsEnabled; }

    public boolean isTwoFactorAuthRequired() { return twoFactorAuthRequired; }
    public void setTwoFactorAuthRequired(boolean twoFactorAuthRequired) { this.twoFactorAuthRequired = twoFactorAuthRequired; }

    public int getSessionTimeoutMinutes() { return sessionTimeoutMinutes; }
    public void setSessionTimeoutMinutes(int sessionTimeoutMinutes) { this.sessionTimeoutMinutes = sessionTimeoutMinutes; }
}
