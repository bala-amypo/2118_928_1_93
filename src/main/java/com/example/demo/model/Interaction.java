package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interactions")
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drugA;
    private String drugB;
    private String severity;
    private String description;

    public Interaction() {
    }

    public Interaction(String drugA, String drugB, String severity, String description) {
        this.drugA = drugA;
        this.drugB = drugB;
        this.severity = severity;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getDrugA() {
        return drugA;
    }

    public void setDrugA(String drugA) {
        this.drugA = drugA;
    }

    public String getDrugB() {
        return drugB;
    }

    public void setDrugB(String drugB) {
        this.drugB = drugB;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
