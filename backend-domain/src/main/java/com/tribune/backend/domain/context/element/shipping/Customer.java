package com.tribune.backend.domain.context.element.shipping;


import com.tribune.backend.domain.context.element.ValueObject;
import lombok.Value;

@Value
public class Customer implements ValueObject {
    Long id;
    String name;
}
