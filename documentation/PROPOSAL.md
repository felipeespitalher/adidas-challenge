## Full Pipeline

The proposal solution is split the services to aply a CQRS

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/documentation/images/pipeline.png" width="500" height="350">

# CQRS

One of the most popular practices in event-driven architectures today is called CQRS, which is short for Command Query Responsibility Segregation. CQRS is a style of architecture that allows you to use different models to update and read domain data.

The basic idea of CQRS is that it’s perfectly natural to need to separate the models you’re using to update and read data. The diagram above shows this basic idea.

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/documentation/images/basic_cqrs.png" width="300" height="200">

CQRS is popular for event-driven architectures because [domain events](https://martinfowler.com/eaaDev/DomainEvent.html) — as inputs — are structurally different than the [domain model](https://martinfowler.com/eaaCatalog/domainModel.html) they are subject to

# Proposal architecture

The proposal is to segregate the projects onto 3 micro services distributed through container images:

 - Command service:  Service responsible to handle any event store mutation;
 - Processor service: Act as a event processor, subscribing for the events that alter the states and feeding the read-side perspective;
 - Query service: Materialize the data projection for the given requirement which is in our case, a graph structural search;

## Command Service

The next service is the Processor Service. This CQRS component takes the form of a worker application that is responsible for ingesting any events to propagate to the read-side. The event processor is stateless and listens for messages from the event stream, applying an action for incoming event messages.

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/documentation/images/command_service.png" width="100" height="200">

When Command service's API be triggered then events to Event Store'll be triggered too (KAFKA). [Event store](https://en.wikipedia.org/wiki/Event_store) is a fancy way to say "a system that combines a database together with a message broker."

## Processor Service

The next service is the Processor Service. This CQRS component takes the form of a worker application that is responsible for ingesting any events to propagate to the read-side. The event processor is stateless and listens for messages from the event stream, applying an action for incoming event messages.

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/documentation/images/processor_service.png" width="300" height="250">

For each event that Processor receive a new register at NEO4J is created. Also Processor doesn't have an expose API, because it's only responsibility is handle the events and persist.

## Query Service

The last service is the Query Service and it's is responsible to materialize the data being searched in a requested manner, in our scenario the neo4j implements a graph database which makes the search algorithm preferable then other options such as RDBMS or Lucene queries.

<img src="https://github.com/felipeespitalher/adidas-challenge/raw/master/documentation/images/query_service.png" width="350" height="250">
