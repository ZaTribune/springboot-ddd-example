package com.tribune.backend.infrastructure.db.repository;


import com.tribune.backend.infrastructure.db.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
