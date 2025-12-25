package com.example.demo.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "interaction_check_results")
public class InteractionCheckResult {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(nullable = false, length = 1000)
private String medications;


@Column(nullable = false, length = 4000)
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


@PrePersist
public void onCreate() {
this.checkedAt = LocalDateTime.now();
}


// getters and setters
}