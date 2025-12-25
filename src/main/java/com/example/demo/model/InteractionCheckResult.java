package com.example.demo.model;


import jakarta.persistence.*;


@Entity
public class InteractionCheckResult {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String result;
}