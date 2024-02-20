package com.ecom.product.repository;

import com.ecom.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    @Query(value = "SELECT name, MAX(price) AS max_price, MAX(product_id) AS max_product_id, MAX(description) AS max_description, MAX(quantity_available) AS max_quantity_available FROM view_product_details WHERE name =:productName group by name", nativeQuery = true)
    Optional<List<Map<String, Object>>> findByName(@Param("productName") String productName);
}
