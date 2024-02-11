package com.ecom.product.repository;

import com.ecom.product.model.EcomProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcomProductDao extends JpaRepository<EcomProductModel, Long> {

}
