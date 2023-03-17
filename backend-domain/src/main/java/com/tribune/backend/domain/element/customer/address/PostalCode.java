package com.tribune.backend.domain.element.customer.address;

import lombok.NonNull;
import lombok.Value;

@Value
public class PostalCode {

    @NonNull String value;

    @Override
    public String toString() {
        return value;
    }
}
