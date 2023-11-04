package com.tribune.backend.domain.dto;

import lombok.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpdateOrderRequest {

    @NotNull(message = "Content is missing.")
    @Min(value = 20)
    private String content;

    @NotNull
    @NotEmpty
    @NotBlank
    private String user;

}
