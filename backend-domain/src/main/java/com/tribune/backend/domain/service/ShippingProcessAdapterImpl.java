package com.tribune.backend.domain.service;

import com.tribune.backend.domain.context.ShippingProcess;
import com.tribune.backend.domain.context.element.shipping.ShippingStatus;
import com.tribune.backend.domain.dto.ShippingStatusResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ShippingProcessAdapterImpl implements ShippingProcessAdapter {


    @Override
    public ShippingStatusResponse processAddress(ShippingProcess shippingProcess) {

        log.info("validating ShippingProcess - {}", shippingProcess);

        //do some logic here

        return ShippingStatusResponse.builder()
                .address(shippingProcess.getAddress())
                .order(shippingProcess.getOrder())
                .status(ShippingStatus.APPROVED)
                .build();
    }
}
