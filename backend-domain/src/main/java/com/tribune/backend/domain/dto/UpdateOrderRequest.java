package com.tribune.backend.domain.dto;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
