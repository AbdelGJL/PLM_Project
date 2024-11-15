package com.example.plm;

import java.util.Date;

public class Project {
    private String projectId;
    private String name;
    private String description;
    private String status;
    private Date startDate;
    private Date endDate;
    private User projectManager;

    // Constructeur
    public Project() {
    }

    public Project(String projectId, String name, String description, String status) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.status = status;
        this.startDate = new Date();
    }

    // Getters et Setters
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }

    // Méthodes métier
    public void startProject() {
        this.status = "STARTED";
        this.startDate = new Date();
    }

    public void updateProjectStatus() {
        // Logique de mise à jour du statut
    }

    public void completeProject() {
        this.status = "COMPLETED";
        this.endDate = new Date();
    }

    public boolean isActive() {
        return "STARTED".equals(this.status);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + projectId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}