package com.tribune.backend.infrastructure.mappers;


import com.tribune.backend.domain.context.element.order.lineitem.product.Product;
import com.tribune.backend.infrastructure.db.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toProduct(ProductEntity entity);

    ProductEntity toProductEntity(Product product);
}
