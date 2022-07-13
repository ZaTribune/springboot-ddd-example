package com.tribune.backend.infrastructure.config;

import com.tribune.backend.domain.dto.GenericResponse;
import com.tribune.backend.infrastructure.config.security.SecurityConfig;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.ws.rs.core.Response.Status.Family.SUCCESSFUL;

/**
 * top tier config file : a config for configs
 * can log responses as following:
 *
 * ObjectMapper mapper=new ObjectMapper();
 * mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
 *
 * ... mapper.writeValueAsString(value)
 **/
@Configuration
public class AppConfig {

    /**
     * Fix cycle dependency formed by {@link org.keycloak.adapters.KeycloakConfigResolver}
     * if specified within {@link SecurityConfig}
     **/
    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {

        return builder -> {
            JsonSerializer<Response> jsonSerializer = new JsonSerializer<>() {
                @Override
                public void serialize(Response value, JsonGenerator gen, SerializerProvider serializers) throws IOException {

                    String message = value.getStatusInfo().getFamily().equals(SUCCESSFUL) ? "Success" : "Error";
                    List<String> reason = new ArrayList<>();
                    Object data = null;
                    switch (value.getStatusInfo().getStatusCode()) {
                        case 409:
                            reason.add("Email/username already exists!");
                            break;
                        case 201:
                            //returns as a result of newly generated resources
                            //returns a URL that ends with the newly created resource id
                            //"http://localhost:8080/auth/admin/realms/tribune/users/b61adfce-ffe6-4d68-9169-0c476ae11179"
                            data = value.getLocation();
                            break;
                    }
                    reason.add(value.getStatusInfo().getReasonPhrase());

                    GenericResponse<?> response = GenericResponse.builder()
                            .data(data)
                            .code(value.getStatus())
                            .message(message)
                            .reason(reason)
                            .build();

                    gen.writePOJO(response);

                }
            };

            builder.serializerByType(Response.class, jsonSerializer);
        };
    }
}
