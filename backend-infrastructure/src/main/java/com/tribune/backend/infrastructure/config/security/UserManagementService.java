package com.tribune.backend.infrastructure.config.security;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tribune.backend.domain.dto.GenericResponse;
import org.keycloak.representations.idm.UserRepresentation;

import javax.ws.rs.core.Response;
import java.util.List;


public interface UserManagementService {

    Response addUser(UserDTO userDTO);

    List<UserRepresentation> getUser(String userName);

    void updateUser(String userId, UserDTO userDTO);
    void deleteUser(String userId);

    void sendVerificationLink(String userId);

    void sendResetPassword(String userId);

    GenericResponse<ObjectNode> authenticate(UserLoginRequest userDTO);
}
