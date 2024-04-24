package com.example.prueba.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table (name = "brands")
@Data
public class Brands {
    @Id
    private Short brandId;

    private String name;

    public Brands(short i, String zara) {
    }

    public Brands() {
    }

    public Brands(Short brandId, String name) {
        this.brandId = brandId;
        this.name = name;
    }
}
