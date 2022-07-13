package com.tribune.backend.infrastructure.controller;

import com.tribune.backend.domain.dto.PlaceOrderRequest;
import com.tribune.backend.domain.dto.GenericResponse;
import com.tribune.backend.domain.dto.SingleOrderResponse;
import com.tribune.backend.infrastructure.services.OrderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@AllArgsConstructor
@RequestMapping("/v1/orders")
@RestController
public class OrdersController {

    private final OrderService orderService;

    @PostMapping("/order")
    public GenericResponse<SingleOrderResponse> createBlog(@Valid @RequestBody PlaceOrderRequest createOrderRequest) {

        return GenericResponse.<SingleOrderResponse>builder()
                .code(201)
                .data(orderService.placeOrder(createOrderRequest))
                .message("Created!")
                .build();
    }
}
