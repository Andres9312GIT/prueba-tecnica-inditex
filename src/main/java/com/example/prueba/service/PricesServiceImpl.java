package com.example.prueba.service;

import com.example.prueba.entity.Prices;
import com.example.prueba.repository.PricesRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
public class PricesServiceImpl implements PricesServiceInterface{

    private final PricesRepository pricesRepository;

    public PricesServiceImpl(PricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public Prices getProductPrice(Integer productId, LocalDateTime date, Short brandId) {
        return pricesRepository.findPriceByProductIdAndBrandIdAndDate(productId, brandId, date).stream()
                .max(Comparator.comparing(Prices::getPriority))
                .orElseThrow();
    }
}
