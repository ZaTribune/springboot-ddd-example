package com.tribune.backend.domain.service;

import com.tribune.backend.domain.context.ShippingProcess;
import com.tribune.backend.domain.dto.ShippingStatusResponse;

public interface ShippingProcessAdapter {


    ShippingStatusResponse processAddress(ShippingProcess shippingProcess);
}
