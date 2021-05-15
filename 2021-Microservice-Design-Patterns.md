# 2021-Microservice-Design-Patterns

#### What are microservices?

* Microservices - also known as the microservice architecture - is an architectural style that structures an application as a collection of services that are
  * Highly maintainable and testable
  * Loosely coupled
  * Independently deployable
  * Organized around business capabilities
  * Owned by a small team
* The microservice architecture enables the rapid, frequent and reliable delivery of large, complex applications. It also enables an organization to evolve its technology stack.

## Difference between monolithic and microservices architecture

* Monolithic architecture  is built as one large system and is usually one code-base. Monolithic application is tightly coupled and entangled as the application evolves, making it difficult to isolate services for purposes such as independent scaling or code maintainability.

* It extremely difficult to change technology or language or framework because everything is tightly coupled and depend on each other.

* Microservices architecture is built as small independent module based on business functionality. In microservices application, each project and services are independent from each other at the code level. Therefore it is easy to  configure and deploy completely and also easy to scale based on demand.

**Key** |	**Monolithic architecture** |	**Microservices architecture**
----------- | ----------------- | -----------------
Basic | Monolithic architecture is built as one large system and is usually one code-base | Microservices architecture is built as small independent module based on business functionality
Scale | It is not easy to scale based on demand | It is easy to scale based on demand.
Database | It has shared database | Each project and module has their own database.
Deployment |Large code base makes IDE slow and build time gets increase.|Each project is independent and small in size. So overall build and development time gets decrease.
Tightly Coupled and Loosely coupled |It extremely difficult to change technology or language or framework because everything is tightly coupled and depend on each other | Easy to change technology or framework because every module and project is independent



* https://microservices.io/patterns/microservices.html


## Design Patterns of Microservices

  *  **Aggregator**
  *  **API Gateway**
  *  **Chained or Chain of Responsibility**
  *  **Asynchronous Messaging**
  *  **Database or Shared Data**
  *  **Event Sourcing**
  *  **Branch**
  *  **Command Query Responsibility Segregator**
  *  **Circuit Breaker**
  *  **Decomposition**

* **Reference:**  https://towardsdatascience.com/microservice-architecture-and-its-10-most-important-design-patterns-824952d7fa41

* https://www.edureka.co/blog/microservices-design-patterns

* https://dzone.com/articles/design-patterns-for-microservices
* https://examples.javacodegeeks.com/design-patterns-for-microservices/

## Saga distributed transactions
* **Reference** : https://docs.microsoft.com/en-us/azure/architecture/reference-architectures/saga/saga#:~:text=The%20saga%20design%20pattern%20is,trigger%20the%20next%20transaction%20step.

