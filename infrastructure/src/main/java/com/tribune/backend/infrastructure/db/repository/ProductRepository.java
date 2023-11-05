package com.tribune.backend.infrastructure.db.repository;


import com.tribune.backend.infrastructure.db.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> getAllByIdIn(List<Long> ids);
}
