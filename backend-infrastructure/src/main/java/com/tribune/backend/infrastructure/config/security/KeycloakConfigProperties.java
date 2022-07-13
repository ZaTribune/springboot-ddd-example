package com.tribune.backend.infrastructure.config.security;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Slf4j
@Getter
@Setter
@ConfigurationProperties(prefix = "tribune.keycloak.client.user-management")
public class KeycloakConfigProperties {

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;
    @Value("${keycloak.realm}")
    private String realm;
    private String resource;
    private String clientSecret;
    private String username;
    private String password;

    public UsersResource getInstance(){
        ResteasyClient resteasyClient=new ResteasyClientBuilder()
                .connectionPoolSize(10)
                .build();
        return KeycloakBuilder.builder()
                .serverUrl(authServerUrl)
                .realm(realm)
                .grantType(OAuth2Constants.PASSWORD)
                .username(username)
                .password(password)
                .clientId(resource)
                .clientSecret(clientSecret)
                .resteasyClient(resteasyClient)
                .build().realm(realm).users();
    }
}
