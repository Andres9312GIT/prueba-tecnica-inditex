package com.example.prueba.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
@Data
public class Prices {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brandId")
    private Brands brand;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Short priceList;

    private Integer productId;

    private Short priority;

    private BigDecimal price;

    private String currency;

    public Prices(Integer id, Brands brand, LocalDateTime startDate, LocalDateTime endDate, Short priceList, Integer productId, Short priority, BigDecimal price, String currency) {
        this.id = id;
        this.brand = brand;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priceList = priceList;
        this.productId = productId;
        this.priority = priority;
        this.price = price;
        this.currency = currency;
    }

    public Prices() {
    }

    public Short getPriority() {
        return priority;
    }
}
