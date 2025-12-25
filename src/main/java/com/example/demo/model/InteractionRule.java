package com.example.demo.model;


import jakarta.persistence.*;


@Entity
public class InteractionRule {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String description;
}