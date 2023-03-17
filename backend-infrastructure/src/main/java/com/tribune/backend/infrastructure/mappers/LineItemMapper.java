package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.element.order.lineitem.LineItem;
import com.tribune.backend.infrastructure.db.entities.LineItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LineItemMapper {

    @Mapping(source = "product.id", target = "product")
    @Mapping(source = "customerOrder", target = "order")
    LineItem toLineItem(LineItemEntity entity);

    @Mapping(source = "product", target = "product.id")
    @Mapping(source = "order", target = "customerOrder")
    LineItemEntity toLineItemEntity(LineItem lineItem);

}
