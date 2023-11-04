package com.tribune.backend.infrastructure.db.repository;


import com.tribune.backend.infrastructure.db.entities.ShippingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<ShippingEntity, Long> {

}

