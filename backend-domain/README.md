# domain module
Contains all the business information that must be consistent and generic all time.


### Notes
- Contracts (adapters) implementations should NOT contain any business logic.  
- All operations with Domain objects should be initiated and encapsulated only in domain module.
- When using Aggregates: 
  - **Aggregate Root** is the mothership entity inside the aggregate.   
  - It identifies a transaction boundaries so that an aggregate root and all related boundaries
should be modified following strong consistency principle (oppose to domain events
and eventual consistency for cross aggregation root changes).

- In general, your infrastructure can depend on your domain. 
The other way around is not ok.  
Think about it this way:  
what is more likely to be replaced at some point?  
Infrastructure or domain?  
Infrastructure will change over time (different providers, different servers, ...)
- , Your domain on the other hand will always be there.


