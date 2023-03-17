package com.tribune.backend.domain.element.customer.address;

import lombok.NonNull;
import lombok.Value;

@Value
public class Street {
    @NonNull String name;
    String streetNumber;
}
