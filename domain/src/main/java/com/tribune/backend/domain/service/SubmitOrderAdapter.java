package com.tribune.backend.domain.service;

import com.tribune.backend.domain.context.CustomerOrder;
import com.tribune.backend.domain.dto.SingleOrderResponse;

public interface SubmitOrderAdapter {


    SingleOrderResponse validateOrder(CustomerOrder customerOrder);
}
