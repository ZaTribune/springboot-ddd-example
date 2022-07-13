package com.tribune.backend.domain.dto;


import com.tribune.backend.domain.enums.BlogStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SingleOrderResponse {

    private String id;

    private String title;

    private String content;

    private BlogStatus status;

    private String appUser;

    private LocalDateTime creationTimestamp;

    private LocalDateTime updateTimestamp;
}
