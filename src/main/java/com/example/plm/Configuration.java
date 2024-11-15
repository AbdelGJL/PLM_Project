package com.example.plm;

import java.util.Date;

public class Configuration {
    private String configId;
    private String version;
    private String status;
    private Date effectiveDate;
    private String description;
    private boolean isActive;

    // Constructeur
    public Configuration() {
    }

    public Configuration(String configId, String version, String status, Date effectiveDate) {
        this.configId = configId;
        this.version = version;
        this.status = status;
        this.effectiveDate = effectiveDate;
        this.isActive = false;
    }

    // Getters et Setters
    public String getConfigId() {
        return configId;
    }

    public void setConfigId(String configId) {
        this.configId = configId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Méthodes métier
    public void createConfig() {
        // Logique de création de configuration
    }

    public void updateConfig() {
        // Logique de mise à jour de configuration
    }

    public void applyConfig() {
        this.isActive = true;
        this.status = "APPLIED";
    }

    public void validateConfig() {
        // Logique de validation de configuration
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "configId='" + configId + '\'' +
                ", version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", effectiveDate=" + effectiveDate +
                ", isActive=" + isActive +
                '}';
    }
}