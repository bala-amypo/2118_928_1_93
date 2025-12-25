package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interaction_rules")
public class InteractionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String drugA;
    private String drugB;
    private String severity;
    private String description;

    public InteractionRule() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
