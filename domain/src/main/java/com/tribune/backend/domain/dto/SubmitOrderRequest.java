package com.tribune.backend.domain.dto;

import com.tribune.backend.domain.context.element.order.Order;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


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
    private Long address;


    @NotNull
    private Order order;
}
