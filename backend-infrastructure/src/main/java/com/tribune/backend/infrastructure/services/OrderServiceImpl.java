package com.tribune.backend.infrastructure.services;

import com.tribune.backend.domain.dto.*;
import com.tribune.backend.infrastructure.db.entities.OrderEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OrderServiceImpl implements OrderService {


    @Override
    public OrderEntity getById(String id) {
        return null;
    }

    @Override
    public SingleOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
        return null;
    }

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
