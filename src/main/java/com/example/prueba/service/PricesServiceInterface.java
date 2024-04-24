package com.example.prueba.service;

import com.example.prueba.entity.Prices;

import java.time.LocalDateTime;

public interface PricesServiceInterface {
    Prices getProductPrice(Integer productId, LocalDateTime date, Short brandId);
}
