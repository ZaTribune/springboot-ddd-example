package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.context.element.common.address.Address;
import com.tribune.backend.infrastructure.db.entities.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    @Mapping(source = "customer.id", target = "customer.id")
    @Mapping(source = "customer.displayName", target = "customer.name")
    @Mapping(source = "street", target = "street.name")
    @Mapping(source = "postalCode", target = "postalCode.value")
    @Mapping(source = "country", target = "country.code")
    Address toAddress(AddressEntity entity);

    @Mapping(source = "customer.id", target = "customer.id")
    @Mapping(source = "customer.name", target = "customer.displayName")
    @Mapping(source = "street.name", target = "street")
    @Mapping(source = "postalCode.value", target = "postalCode")
    @Mapping(source = "country.code", target = "country")
    AddressEntity toAddressEntity(Address address);
}
