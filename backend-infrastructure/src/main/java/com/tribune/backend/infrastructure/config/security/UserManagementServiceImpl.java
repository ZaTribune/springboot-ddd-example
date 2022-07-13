package com.tribune.backend.infrastructure.config.security;

import com.tribune.backend.domain.dto.GenericResponse;
import com.tribune.backend.infrastructure.error.BackendException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.netty.http.client.HttpClient;

import javax.ws.rs.core.Response;
import java.net.URI;
import java.time.Duration;
import java.util.Collections;
import java.util.List;


@Slf4j
@Service
public class UserManagementServiceImpl implements UserManagementService {
    @Value("${keycloak.resource}")
    private String tribuneSpringbootClient;

    private final KeycloakConfigProperties properties;

    @Autowired
    public UserManagementServiceImpl(KeycloakConfigProperties properties) {
        this.properties = properties;
    }

    @Override
    public Response addUser(UserDTO userDTO) {
        CredentialRepresentation credential = CredentialsUtils
                .createPasswordCredentials(userDTO.getPassword());

        UserRepresentation user = new UserRepresentation();

        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);

        return properties.getInstance().create(user);
    }

    @Override
    public List<UserRepresentation> getUser(String userName) {
        return properties.getInstance().search(userName, true);
    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        CredentialRepresentation credential = CredentialsUtils
                .createPasswordCredentials(userDTO.getPassword());
        UserRepresentation user = new UserRepresentation();
        user.setUsername(userDTO.getUsername());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setCredentials(Collections.singletonList(credential));
        //todo:needs confirmation
        properties.getInstance().get(userId).update(user);
    }

    @Override
    public void deleteUser(String userId) {
        //todo:needs confirmation
        properties.getInstance().get(userId)
                .remove();
    }

    @Override
    public void sendVerificationLink(String userId) {
        //todo:needs confirmation
        properties.getInstance().get(userId)
                .sendVerifyEmail();
    }

    @Override
    public void sendResetPassword(String userId) {
        //todo:needs confirmation
        properties.getInstance().get(userId)
                .executeActionsEmail(List.of("UPDATE_PASSWORD"));
    }

    @Override
    public GenericResponse<ObjectNode> authenticate(UserLoginRequest userDTO) {
        URI uri=UriComponentsBuilder.fromUriString(
                String.format("%s/realms/%s/protocol/openid-connect/token",
                        properties.getAuthServerUrl(), properties.getRealm())
        ).build().toUri();

        HttpClient httpClient = HttpClient.create()
                .responseTimeout(Duration.ofSeconds(2));

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("username", userDTO.getUsername());
        formData.add("password", userDTO.getPassword());
        formData.add("client_id", tribuneSpringbootClient);
        formData.add("grant_type", CredentialRepresentation.PASSWORD);

        ObjectNode node= WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build()
                .post()
                .uri(uri)
                .body(BodyInserters.fromFormData(formData))
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is4xxClientError()) {
                        log.error("error");
                        return clientResponse.bodyToMono(ObjectNode.class).map(val -> {

                            throw new BackendException(val, clientResponse.statusCode());
                        });
                    } else
                        return clientResponse.bodyToMono(ObjectNode.class);
                })
                .block();

        return GenericResponse.<ObjectNode>builder()
                .code(200)
                .message("Success!")
                .data(node)
                .build();
    }
}
