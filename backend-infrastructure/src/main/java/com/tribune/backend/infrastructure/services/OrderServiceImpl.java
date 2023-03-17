package com.tribune.backend.infrastructure.services;


import com.tribune.backend.domain.context.CustomerOrder;
import com.tribune.backend.domain.dto.*;
import com.tribune.backend.domain.element.customer.Customer;
import com.tribune.backend.domain.element.order.lineitem.LineItem;
import com.tribune.backend.domain.enums.OrderStatus;
import com.tribune.backend.domain.service.PlaceOrderAdapter;
import com.tribune.backend.infrastructure.db.entities.CustomerEntity;
import com.tribune.backend.infrastructure.db.entities.OrderEntity;
import com.tribune.backend.infrastructure.db.entities.ProductEntity;
import com.tribune.backend.infrastructure.db.repository.CustomerRepository;
import com.tribune.backend.infrastructure.db.repository.OrderRepository;
import com.tribune.backend.infrastructure.db.repository.ProductRepository;
import com.tribune.backend.infrastructure.error.NotFoundException;
import com.tribune.backend.infrastructure.mappers.CustomerMapperImpl;
import com.tribune.backend.infrastructure.mappers.OrderMapperImpl;
import com.tribune.backend.infrastructure.mappers.ProductMapperImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;

    private final PlaceOrderAdapter adapter;


    private final CustomerMapperImpl customerMapper;

    private final OrderMapperImpl orderMapper;

    private final ProductMapperImpl productMapper;


    @Override
    public OrderEntity getById(String id) {
        return null;
    }

    @Override
    public SingleOrderResponse processOrder(SubmitOrderRequest submitOrderRequest) throws NotFoundException {

        log.info("Process order - {}", submitOrderRequest);
        // now I'm on infrastructure
        // I need to execute a business case
        // Business is executed on domain
        // how will I execute this business on domain?
        // I need to obtain info about this business case and transform it to domain element encapsulated within a bounded context
        // then be transferred to the domain

        CustomerEntity customerEntity = customerRepository.findById(submitOrderRequest.getUser())
                .orElseThrow(() -> new NotFoundException("No customer was found by the given id"));


        // same with product list
        List<Long> ids = submitOrderRequest.getOrder().getLineItems()
                .stream().map(LineItem::getProduct).collect(Collectors.toList());
        log.info("product ids:{}", ids);
        List<ProductEntity> productEntities = productRepository.findByIdIn(ids);

        log.info("products - {}", productEntities);

        Customer customer = customerMapper.toCustomer(customerEntity);

        OrderEntity orderEntity = orderMapper.toOrderEntity(submitOrderRequest.getOrder());

        orderEntity.setStatus(OrderStatus.INITIALIZED);
        orderRepository.saveAndFlush(orderEntity);


        //map the customer and the order entity to domain element
        //this way we provide input verification ___here's the result after persisting to db
        CustomerOrder customerOrder = CustomerOrder.builder()
                .customer(customer)
                .order(orderMapper.toOrder(orderEntity))
                .products(productEntities.stream().map(productMapper::toProduct).collect(Collectors.toList()))
                .build();

        //after obtaining all info here now it's time to move them to domain to be executed

        SingleOrderResponse response = adapter.validateOrder(customerOrder);


        //persist quantities
        productRepository.saveAll(response.getProducts().stream().map(productMapper::toProductEntity).collect(Collectors.toList()));

        orderEntity.setStatus(OrderStatus.SUBMITTED);

        orderRepository.save(orderEntity);

        return response;
    }


    //here we can update the order status case success/failure of business
    @Override
    public OrderEntity updateOrder(String id, UpdateOrderRequest updateOrderRequest) {
        return null;
    }

    @Override
    public OrdersResponse getAll(Integer page, Integer size, String sortBy, String direction) {
        return null;
    }

    @Override
    public GenericResponse<Void> deleteById(String id, String token) {
        return null;
    }
}
