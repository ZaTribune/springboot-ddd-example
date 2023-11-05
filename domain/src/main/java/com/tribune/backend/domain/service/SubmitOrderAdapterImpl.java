package com.tribune.backend.domain.service;


import com.tribune.backend.domain.context.CustomerOrder;
import com.tribune.backend.domain.dto.SingleOrderResponse;
import com.tribune.backend.domain.context.element.customer.Customer;
import com.tribune.backend.domain.context.element.customer.CustomerState;
import com.tribune.backend.domain.context.element.order.Order;
import com.tribune.backend.domain.context.element.order.lineitem.LineItem;
import com.tribune.backend.domain.context.element.order.lineitem.product.Product;
import com.tribune.backend.domain.error.DomainException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Service
public class SubmitOrderAdapterImpl implements SubmitOrderAdapter {



    //execute a business case
    @Override
    public SingleOrderResponse validateOrder(CustomerOrder customerOrder) {

        log.info("validating CustomerOrder - {}", customerOrder);
        List<Product> products = customerOrder.getProducts();

        Order order = customerOrder.getOrder();

        validateCustomer(customerOrder.getCustomer());

        double totalCost = 0.0;

        for (LineItem lineItem : order.getLineItems()) {

            Product product = products.stream().filter(p -> p.getId().equals(lineItem.getProduct()))
                    .findFirst().orElseThrow(() -> new DomainException(400,
                            String.format("No product available with this id [%s].", lineItem.getProduct())));
            //calculate costs
            totalCost += product.getPrice().doubleValue() * lineItem.getQuantity();

            //check for requested quantities
            if (lineItem.getQuantity() <= product.getQuantity()) {
                //subtract the quantity
                product.setQuantity(product.getQuantity() - lineItem.getQuantity());

            } else {
                String error = String.format("Available quantity for product [%s] is %d, requested quantity was %d."
                        , product.getName(), product.getQuantity(), lineItem.getQuantity());
                throw new DomainException(400, error);
            }
        }

        //process payment

        if (order.getPayment().doubleValue() < totalCost) {
            String error = String.format("Total cost for order is %s, provided payment was %s."
                    , totalCost, order.getPayment());
            throw new DomainException(400, error);
        }

        //process Shipping


        return SingleOrderResponse.builder()
                .order(order)
                .totalCost(BigDecimal.valueOf(totalCost))
                .products(products)
                .build();
    }

    private void validateCustomer(Customer customer) {
        if (!customer.getState().equals(CustomerState.ACTIVE)) {
            throw new DomainException(403, String.format("Invalid Customer state - %s", customer.getState()));
        }
    }


}
