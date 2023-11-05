package com.tribune.backend.domain.event;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;


@Slf4j
@Service
public class EventBusImpl implements EventBus {

    private final Map<EventType, List<EventSubscriber>> subscribersMap = new EnumMap<>(EventType.class);


    public EventBusImpl() {
        for (EventType event : EventType.values()) {
            subscribersMap.put(event, new ArrayList<>());
        }
    }

    @Override
    public void publish(CustomSpringEvent event) {
        log.info("publish() - {}", event);
        subscribersMap.get(event.getEventType())
                .forEach(subscriber -> subscriber.onEvent(event));
    }

    @Override
    public void subscribe(EventType event, EventSubscriber newSubscriber) {
        log.info("subscribe() - eventType: {}, newSubscriber: {}", event, newSubscriber);
        subscribersMap.get(event)
                .add(newSubscriber);
    }

    @Override
    public void unsubscribe(EventType event, EventSubscriber subscriber) {
        log.info("subscribe() - eventType: {}, subscriber: {}", event, subscriber);
        subscribersMap.get(event)
                .remove(subscriber);
    }

}
