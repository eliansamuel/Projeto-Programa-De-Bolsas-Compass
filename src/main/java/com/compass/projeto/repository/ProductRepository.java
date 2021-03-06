package com.compass.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.compass.projeto.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    @Query(value = "SELECT * FROM Product WHERE (:q IS NULL OR (UPPER(name) LIKE UPPER(CONCAT('%', :q, '%'))"
            + "OR UPPER(description) LIKE UPPER(CONCAT('%', :q, '%'))))"
            + "AND (:min_price IS NULL OR price >= :min_price)"
            + "AND (:max_price IS NULL OR price <= :max_price)", nativeQuery = true)
    List<Product> findByPrice(@Param("max_price") Double maxPricedb, @Param("min_price") Double minPricedb, @Param("q") String q);

}