package com.tribune.backend.infrastructure.config.security;

import org.keycloak.representations.idm.CredentialRepresentation;

public class CredentialsUtils {

    private CredentialsUtils(){}

    public static CredentialRepresentation createPasswordCredentials(String password) {
        CredentialRepresentation passwordCredentials = new CredentialRepresentation();
        passwordCredentials.setTemporary(false);
        passwordCredentials.setType(CredentialRepresentation.PASSWORD);
        passwordCredentials.setValue(password);
        return passwordCredentials;
    }
}
