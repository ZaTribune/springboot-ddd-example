package com.tribune.backend.domain;

/**
 * Interface for all domain objects that can be uniquely identified in some context
 * @param <ID> - type of identifier (use wrapper on top of primitive types)
 */
public interface IdentifiableDomainObject<ID> extends DomainObject {
    ID getId();
}
