package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.element.order.Order;
import com.tribune.backend.infrastructure.db.entities.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = LineItemMapper.class)
public interface OrderMapper {


    Order toOrder(OrderEntity entity);


    OrderEntity toOrderEntity(Order order);


}
