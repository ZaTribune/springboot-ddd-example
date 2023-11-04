package com.tribune.backend.domain.context.element.common;

import com.tribune.backend.domain.context.element.ValueObject;
import lombok.NonNull;
import lombok.Value;

@Value
public class Country implements ValueObject {

    @NonNull String code;

    public Country(@NonNull String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }
}
