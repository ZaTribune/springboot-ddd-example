package com.tribune.backend.domain.dto;

import com.tribune.backend.domain.element.order.Order;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubmitOrderRequest {

    @NotBlank(message = "Content is missing.")
    private String content;

    @NotNull
    private Long user;


    @NotNull
    private Order order;
}
