package com.tribune.backend.domain.event;


public interface EventSubscriber {

    void onEvent(CustomSpringEvent event);
}
