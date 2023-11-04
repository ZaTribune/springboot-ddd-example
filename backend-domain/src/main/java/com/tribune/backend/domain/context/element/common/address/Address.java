package com.tribune.backend.domain.context.element.common.address;

import com.tribune.backend.domain.context.element.ValueObject;
import com.tribune.backend.domain.context.element.common.Country;
import com.tribune.backend.domain.context.element.shipping.Customer;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Address implements ValueObject {

    String flatNumber;

    @NonNull Street street;

    PostalCode postalCode;

    @NonNull String city;

    @NonNull Country country;

    Customer customer;

    String additionalInformation;
}
