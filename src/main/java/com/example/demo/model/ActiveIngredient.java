package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "active_ingredients", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class ActiveIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public ActiveIngredient() {
    }

    public ActiveIngredient(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
