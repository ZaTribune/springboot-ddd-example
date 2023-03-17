package com.tribune.backend.infrastructure.db.repository;


import com.tribune.backend.infrastructure.db.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}

