package com.tribune.backend.infrastructure.db;


import com.tribune.backend.domain.element.customer.CustomerState;
import com.tribune.backend.domain.element.customer.CustomerType;
import com.tribune.backend.infrastructure.db.entities.CustomerEntity;
import com.tribune.backend.infrastructure.db.entities.ProductEntity;
import com.tribune.backend.infrastructure.db.repository.CustomerRepository;
import com.tribune.backend.infrastructure.db.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


@Slf4j
@Transactional
@AllArgsConstructor
@Component
public class DevBootstrap implements CommandLineRunner {

    private CustomerRepository customerRepository;
    private ProductRepository productRepository;


    @Override
    public void run(String... args) {

        initCustomers();
        initProducts();
    }

    public void initCustomers() {
        customerRepository.deleteAll();
        CustomerEntity customer0 = CustomerEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .type(CustomerType.TRADITIONAL)
                .displayName("Failure")
                .state(CustomerState.ACTIVE)
                .build();
        CustomerEntity customer1 = CustomerEntity.builder()
                .firstName("Bill")
                .lastName("Gates")
                .type(CustomerType.TRADITIONAL)
                .displayName("Billy the beast")
                .state(CustomerState.DISABLED)
                .build();

        customerRepository.saveAll(List.of(customer0, customer1));
    }

    public void initProducts() {
        productRepository.deleteAll();
        ProductEntity product0 = ProductEntity.builder()
                .name("Samsung Galaxy S23")
                .company("Samsung")
                .price(BigDecimal.valueOf(3112.50))
                .quantity(15)
                .build();
        ProductEntity product1 = ProductEntity.builder()
                .name("Iphone 14 pro max")
                .company("Apple")
                .price(BigDecimal.valueOf(2000))
                .quantity(5)
                .build();
        ProductEntity product2 = ProductEntity.builder()
                .name("Xiaomi Note 11")
                .company("Xiaomi")
                .price(BigDecimal.valueOf(800))
                .quantity(22)
                .build();
        ProductEntity product3 = ProductEntity.builder()
                .name("Nokia whatever")
                .company("Nokia")
                .price(BigDecimal.valueOf(1500))
                .quantity(82)
                .build();

        productRepository.saveAll(List.of(product0, product1, product2, product3));

    }
}
