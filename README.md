# Getting Started

This is a demo project to demonstrate the concept of DDD (Domain Driven Development) 
within a monolithic web application.

## DDD in a nutshell

<blockquote><p>You cannot create a banking software system unless you have a good understanding about the domain of banking.</p>
<p>Domain Driven Design - by Eric Evans.</p>
</blockquote>

Our Application usually consists of three layers:
1. **Domain layer** includes all the information about the business case and the business rules.  
2. **Infrastructure layer** supports communication between the domain and other layers.  
Infrastructure layer is an expression/implementation for the domain layer - a way of conducting/executing business information described on domain layer.
Yes, Domain layer is like a java interface, and infrastructure layer is its implementation.  
We express business information through services.  
Services are built using contracts - a way of abstracting business information.
So that for each service, there’s a contract and one or more implementations.  
Contracts like [Adapters - a well-known design pattern] are placed within the domain layer, 
while their implementations are placed within the infrastructure layer.  
Most importantly, the domain layer is in the center of the business application. 
This means that it should be separated from the rest of the layers. 
It shouldn’t depend on the other layers or their frameworks. 
Contracts (adapters) implementations should NOT contain any business logic. 
All operations with Domain objects should be initiated and encapsulated only in domain module. 
So, you can utilize Utils/Tools/Handlers built within domain layer.  
3. **Application layer** a point of control that manages a combination of both previous layers.  
On this project you'll find it encapsulating spring boot configuration properties.   
In general for dependencies in a DDD Service, the Application layer depends on Domain and Infrastructure, 
and Infrastructure depends on Domain, but Domain doesn't depend on any layer / The other way around is not permitted.  
Think about it this way - What is more likely to be replaced at some point? Infrastructure or domain?
Infrastructure will change over time (different providers, different servers, …), 
Your domain on the other hand will always be there.

## Useful Concepts
### Aggregates
* For each business feature delivered, it can be wrapped within what’s called a **BoundedContext**.
* To use Aggregates please read this article offered by [Bealdung](https://baeldung-cn.com/java-modules-ddd-bounded-contexts).
* Aggregate Root is the mothership entity inside the aggregate.
* It identifies a transaction boundary so that an aggregate root and all related boundaries 
should be modified following strong consistency principle (oppose to domain events 
and eventual consistency for cross aggregation root changes).


## Deployment notes

Environment Variables:  
* host
* keycloak.credentials.secret



## Authors
[![Linkedin](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white&label=Muhammad%20Ali)](https://linkedin.com/in/zatribune)

