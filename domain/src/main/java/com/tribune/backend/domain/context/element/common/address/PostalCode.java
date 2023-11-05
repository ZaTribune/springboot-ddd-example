package com.tribune.backend.domain.context.element.common.address;

import com.tribune.backend.domain.context.element.ValueObject;
import lombok.NonNull;
import lombok.Value;

@Value
public class PostalCode implements ValueObject {

    @NonNull String value;

    @Override
    public String toString() {
        return value;
    }
}
