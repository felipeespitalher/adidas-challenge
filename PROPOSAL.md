## Full Pipeline

The proposal solution is slit the services to aply a CQRS

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/gallery/pipeline.png" width="500" height="350">

# CQRS

One of the most popular practices in event-driven architectures today is called CQRS, which is short for Command Query Responsibility Segregation. CQRS is a style of architecture that allows you to use different models to update and read domain data.

The basic idea of CQRS is that it’s perfectly natural to need to separate the models you’re using to update and read data. The diagram above shows this basic idea.

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/gallery/basic_cqrs.png" width="300" height="200">

CQRS is popular for event-driven architectures because [domain events](https://martinfowler.com/eaaDev/DomainEvent.html) — as inputs — are structurally different than the [domain model](https://martinfowler.com/eaaCatalog/domainModel.html) they are subject to

# CQRS and Microservices

So, this test is divided into three microservices, Command Service, Processor Service, and Query Service.

## Command Service

It's REST API that accepts requests over HTTP. Requests take the form of commands that drive state changes to domain data owned by the microservice. To put it simply, any writes on domain data will flow from an API request as a command.

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/gallery/command_service.png" width="100" height="200">

When Command service's API be triggered then events to Event Store'll be triggered too (KAFKA). [Event store](https://en.wikipedia.org/wiki/Event_store) is a fancy way to say "a system that combines a database together with a message broker."

## Processor Service

The next service is the Processor Service. This CQRS component takes the form of a worker application that is responsible for ingesting domain events. The event processor is stateless and listens for messages from the event store, applying an action for incoming event messages.

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/gallery/processor_service.png" width="300" height="250">

For each event that Processor receive a new register at NEO4J is created. Also Processor doesn't have an expose API, because it's only responsibility is handle the events and persist.

## Query Service

The last service is the Query Service and it's is responsible for search data at NEO4J.

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/gallery/query_service.png" width="350" height="250">
