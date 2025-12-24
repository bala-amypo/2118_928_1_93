package com.example.demo.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "active_ingredients")
public class ActiveIngredient {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


@Column(unique = true, nullable = false)
private String name;


public ActiveIngredient() {}


public ActiveIngredient(String name) {
this.name = name;
}


// getters and setters
}