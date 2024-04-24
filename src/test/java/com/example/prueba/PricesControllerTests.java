package com.example.prueba;

import com.example.prueba.controller.PricesController;
import com.example.prueba.entity.Brands;
import com.example.prueba.entity.Prices;
import com.example.prueba.service.PricesServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PricesControllerTests {

    private static final Integer PRODUCT_ID = 35455;
    private static final Short BRAND_ID = 1;

    private PricesController pricesController;

    @Mock
    private PricesServiceImpl pricesService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        pricesController = new PricesController(pricesService);
    }
    @Test
    public void case1() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T10:00:00");
        Prices prices = new Prices(1, new Brands((short) 1,"ZARA"), LocalDateTime.parse("2020-06-14T00:00:00"),LocalDateTime.parse("2020-12-31T23:59:59"),(short) 1,35455,(short) 0,new BigDecimal(Double.toString(35.50)),"EUR");
        when(pricesService.getProductPrice(PRODUCT_ID, date, BRAND_ID)).thenReturn(prices);

        ResponseEntity response = pricesController.getProductPrices(PRODUCT_ID, date, BRAND_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prices, response.getBody());
        verify(pricesService, times(1)).getProductPrice(PRODUCT_ID, date, BRAND_ID);
    }
    @Test
    public void case2() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T16:00:00");
        Prices prices = new Prices(2, new Brands((short) 1,"ZARA"), LocalDateTime.parse("2020-06-14T15:00:00"),LocalDateTime.parse("2020-06-14T18:30:00"),(short) 2,35455,(short) 1,new BigDecimal(Double.toString(25.45)),"EUR");
        when(pricesService.getProductPrice(PRODUCT_ID, date, BRAND_ID)).thenReturn(prices);

        ResponseEntity response = pricesController.getProductPrices(PRODUCT_ID, date, BRAND_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prices, response.getBody());
        verify(pricesService, times(1)).getProductPrice(PRODUCT_ID, date, BRAND_ID);
    }
    @Test
    public void case3() {
        LocalDateTime date = LocalDateTime.parse("2020-06-14T21:00:00");
        Prices prices = new Prices(1, new Brands((short) 1,"ZARA"), LocalDateTime.parse("2020-06-14T00:00:00"),LocalDateTime.parse("2020-12-31T23:59:59"),(short) 1,35455,(short) 0,new BigDecimal(Double.toString(35.50)),"EUR");
        when(pricesService.getProductPrice(PRODUCT_ID, date, BRAND_ID)).thenReturn(prices);

        ResponseEntity response = pricesController.getProductPrices(PRODUCT_ID, date, BRAND_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prices, response.getBody());
        verify(pricesService, times(1)).getProductPrice(PRODUCT_ID, date, BRAND_ID);
    }

    @Test
    public void case4() {
        LocalDateTime date = LocalDateTime.parse("2020-06-15T10:00:00");
        Prices prices = new Prices(3, new Brands((short) 1,"ZARA"), LocalDateTime.parse("2020-06-15T00:00:00"),LocalDateTime.parse("2020-06-15T11:00:00"),(short) 3,35455,(short) 1,new BigDecimal(Double.toString(30.50)),"EUR");
        when(pricesService.getProductPrice(PRODUCT_ID, date, BRAND_ID)).thenReturn(prices);

        ResponseEntity response = pricesController.getProductPrices(PRODUCT_ID, date, BRAND_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prices, response.getBody());
        verify(pricesService, times(1)).getProductPrice(PRODUCT_ID, date, BRAND_ID);
    }

    @Test
    public void case5() {
        LocalDateTime date = LocalDateTime.parse("2020-06-16T21:00:00");
        Prices prices = new Prices(4, new Brands((short) 1,"ZARA"), LocalDateTime.parse("2020-06-15T16:00:00"),LocalDateTime.parse("2020-12-31T23:59:59"),(short) 4,35455,(short) 1,new BigDecimal(Double.toString(38.95)),"EUR");
        when(pricesService.getProductPrice(PRODUCT_ID, date, BRAND_ID)).thenReturn(prices);

        ResponseEntity response = pricesController.getProductPrices(PRODUCT_ID, date, BRAND_ID);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prices, response.getBody());
        verify(pricesService, times(1)).getProductPrice(PRODUCT_ID, date, BRAND_ID);
    }
}