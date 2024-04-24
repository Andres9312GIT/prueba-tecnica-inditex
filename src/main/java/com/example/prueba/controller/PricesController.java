package com.example.prueba.controller;

import com.example.prueba.entity.Prices;
import com.example.prueba.service.PricesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/product-prices")
public class PricesController {

    private final PricesServiceImpl pricesService;

    public PricesController(PricesServiceImpl pricesService) {
        this.pricesService = pricesService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity getProductPrices(@PathVariable(name = "productId") Integer productId, @RequestParam(name = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date, @RequestParam(name = "brandId") Short brandId){
        try{
            return new ResponseEntity(pricesService.getProductPrice(productId, date, brandId), HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
