package com.tribune.backend.domain.dto;


import lombok.*;

import java.util.List;

@Data
@Builder
public class OrdersResponse {
    private List<SingleOrderResponse> blogs;
}
