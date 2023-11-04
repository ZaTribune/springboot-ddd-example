package com.tribune.backend.domain.context.element;

import lombok.experimental.SuperBuilder;

/**
 * Aggregate Root is the mothership entity inside the aggregate. It identifies
 * a use case boundaries so that an aggregate root and all related boundaries
 * should be modified following strong consistency principle (oppose to domain events
 * and eventual consistency for cross-aggregation root changes).
 *
 * @param <ID> - type of identifier (use wrapper on top of primitive types)
 */
@SuperBuilder
public abstract class AggregateRoot<ID> extends Entity<ID> {
}
