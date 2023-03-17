package com.tribune.backend.infrastructure.db.repository;


import com.tribune.backend.infrastructure.db.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByIdIn(List<Long> ids);
}

