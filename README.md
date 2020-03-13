## springbootdemo
This is a learning project for me to understand the basics of spring and springboot applications in a 
practical way. There's nothing seriously productive about this application except for the fact that it
helps me learn and apply fundamentals of Spring and Springboot based applications.

Following are the concepts I would like to learn and apply:
- Setting up the project using start.spring.io
- Setup basic project structure for the classes.
- Add entity/model classes.
- Entity to DTO and vice-versa using ModelMapper class.
- Understand exception handling and return appropriate error codes.
- Validation of incoming data - TBD.
- Logging - TBD.
- Providing custom configuration using @Configuration class.
- Modifying application.properties
- Use spring-data, JPA and Hibernate - TBD.
- Use actuator starter POM - TBD.
- Aspects to monitor performance - TBD.
- API documentation - TBD.
- Unit testing - TBD.
- Spring integration testing - TBD.

### Notes
#### Entity - DTO
- Always provide a default no-args constructor for the model mapping classes - entity and DTO classes.
- Always provide getters and setters for the entity and DTO classes for the ModelMapper to function correctly.
- Try to create a @ControllerAdvice class to handle exceptions - this would centralize all exception handling.
- Always prefer DTO classes to interact with the external world from the AP layer.
- Using a DTO class shields us from changes to the entities in the application.
- Handling of DTO objects(including conversions to/from entity objects) should be done only at the controller layer.

#### Exception handling
- Exception handling is necessary to return a proper response to the client.
- Service and DAO layers should only raise exceptions and not return ResponseEntity objects directly.
- Exceptions raised by the service and DAO layers that need to be conveyed back to the user should be handled in the 
controller layer and a proper HTTP status code along with reason should be sent to user.
- There are multiple ways to handle exceptions:
    - Create a private method in a controller with `@ExceptionHandler` annotation. This method can return a
    `ResponseEntity` object with proper status code and reason. Multiple exception types can be handled in the same
    exception handler method. Different exception types to be handled are mentioned as an array in the arguments of 
    `@ExceptionHandler` annotation - like so: `@ExceptionHandler({CustomException.class, MyException.class})`.
    - Catch the custom exception in the controller method and return a `ResponseEntity` object with correct message and
    status code.
    - Catch the custom exception in the controller and throw a new `ResponseStatusException` object with reason and 
    status code.
    - Create a class with `@ControllerAdvice` annotation and add a exception handler method with `@ExceptionHandler` 
    annotation. You can then return a `ResponseEntity` object from this method.
    - Spring provides some default exception handlers which return appropriate reason and status code.
    - All exception handlers provided by Spring implement the interface `HandlerExceptionResolver`. Example implementations
    include `DefaultHandlerExceptionResolver`, `SimpleHandlerExceptionResolver`, etc. 
    Reference [here](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/HandlerExceptionResolver.html)