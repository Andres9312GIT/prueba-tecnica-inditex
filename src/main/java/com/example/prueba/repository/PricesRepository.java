package com.example.prueba.repository;

import com.example.prueba.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer> {

    @Query(
            value = "SELECT * FROM prices p WHERE p.product_id = ?1 AND p.brand_id = ?2 AND ?3 BETWEEN p.start_date AND p.end_date",
            nativeQuery = true)
    List<Prices> findPriceByProductIdAndBrandIdAndDate(Integer productId, Short brandId, LocalDateTime date);
}
