package com.example.demo.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "interaction_check_results")
public class InteractionCheckResult {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String medications;


@Column(columnDefinition = "TEXT")
private String interactions;


private LocalDateTime checkedAt;


public InteractionCheckResult() {
this.checkedAt = LocalDateTime.now();
}


public InteractionCheckResult(String medications, String interactions) {
this.medications = medications;
this.interactions = interactions;
this.checkedAt = LocalDateTime.now();
}


// getters and setters
}