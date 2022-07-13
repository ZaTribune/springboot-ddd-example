package com.tribune.backend.domain;

import com.tribune.backend.domain.error.DomainException;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Abstract representation of Domain Entities
 * @param <ID> - type of identifier (use wrapper on top of primitive types)
 */
@SuperBuilder
public abstract class Entity<ID> implements IdentifiableDomainObject<ID> {

    private final List<Object> domainEvents = new ArrayList<>();
    private ID id;

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    protected <T> T registerEvent(T event) {
        if (event==null){
            //todo:
            throw new DomainException("Domain event must not be null!");
        }
        this.domainEvents.add(event);
        return event;
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }

    public List<Object> domainEvents() {
        return Collections.unmodifiableList(this.domainEvents);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Entity<?> entity = (Entity<?>) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}