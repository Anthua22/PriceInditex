package com.inditex.prices.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inditex.prices.domain.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("""
            SELECT p
            FROM Price p
            WHERE p.brandId = :brandId
              AND p.productId = :productId
              AND :applicationDate BETWEEN p.startDate AND p.endDate
            ORDER BY p.priority DESC
            """)
    List<Price> findApplicablePrices(
            Long brandId,
            Long productId,
            LocalDateTime applicationDate);
}
