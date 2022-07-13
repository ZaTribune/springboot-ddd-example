package com.tribune.backend.infrastructure.services;

import com.tribune.backend.domain.dto.*;
import com.tribune.backend.infrastructure.db.entities.OrderEntity;

public interface OrderService {

    OrderEntity getById(String id);
    SingleOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);

    OrderEntity updateOrder(String id, UpdateOrderRequest updateOrderRequest);

    OrdersResponse getAll(Integer page, Integer size, String sortBy, String direction);

    GenericResponse<Void> deleteById(String id, String token);
}
