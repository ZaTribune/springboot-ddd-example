package com.tribune.backend.infrastructure.controller;


import com.fasterxml.jackson.databind.node.ObjectNode;
import com.tribune.backend.domain.dto.GenericResponse;
import com.tribune.backend.infrastructure.config.security.UserDTO;
import com.tribune.backend.infrastructure.config.security.UserLoginRequest;
import com.tribune.backend.infrastructure.config.security.UserManagementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/v1/users")
public class UserController {
    private final UserManagementService service;


    @PostMapping("/user/auth")
    public GenericResponse<ObjectNode> authenticate(@Valid @RequestBody UserLoginRequest userDTO){
        return service.authenticate(userDTO);
    }

    @PostMapping("/user")
    public Response addUser(@Valid @RequestBody UserDTO userDTO){
        return service.addUser(userDTO);
    }

    @GetMapping(path = "/user/{userName}")
    public List<UserRepresentation> getUser(@PathVariable("userName") String userName){
        return service.getUser(userName);
    }

    @PutMapping(path = "/user/{userId}")
    public String updateUser(@PathVariable("userId") String userId, @RequestBody UserDTO userDTO){
        service.updateUser(userId, userDTO);
        return "User Details Updated Successfully.";
    }

    @DeleteMapping(path = "/user/{userId}")
    public String deleteUser(@PathVariable("userId") String userId){
        service.deleteUser(userId);
        return "User Deleted Successfully.";
    }

    @GetMapping(path = "/user/verify/{userId}")
    public String sendVerificationLink(@PathVariable("userId") String userId){
        service.sendVerificationLink(userId);
        return "Verification Link Send to Registered E-mail Id.";
    }

    @GetMapping(path = "/user/reset-password/{userId}")
    public String sendResetPasswordLink(@PathVariable("userId") String userId){
        service.sendResetPassword(userId);
        return "Reset Password Link Send Successfully to Registered E-mail Id.";
    }
}
