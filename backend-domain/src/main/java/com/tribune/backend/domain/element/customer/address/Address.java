package com.tribune.backend.domain.element.customer.address;

import com.tribune.backend.domain.element.ValueObject;
import com.tribune.backend.domain.element.customer.common.Country;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Address implements ValueObject{

    @NonNull Country country;

    @NonNull String city;

    @NonNull Street street;

    String flatNumber;

    String additionalInformation;
}
