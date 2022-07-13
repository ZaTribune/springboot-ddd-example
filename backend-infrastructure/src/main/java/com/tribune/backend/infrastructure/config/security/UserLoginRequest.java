package com.tribune.backend.infrastructure.config.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UserLoginRequest {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
}
