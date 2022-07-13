package com.tribune.backend.infrastructure.config.security;

import com.tribune.backend.domain.dto.GenericResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.keycloak.util.JsonSerialization.mapper;

@Slf4j
@AllArgsConstructor
public class TribuneKeycloakAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException {
        ex.printStackTrace();
        log.error("Authentication Error: {}", ex.getMessage());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        //todo:check removal of WWW_AUTHENTICATE header from response
        GenericResponse<Void> genericResponse = GenericResponse.<Void>builder()
                .message(ex.getMessage())
                .reason(response.getHeader(HttpHeaders.WWW_AUTHENTICATE))
                .code(response.getStatus())
                .build();
        response.getWriter().write(mapper.writeValueAsString(genericResponse));
    }
}