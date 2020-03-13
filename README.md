### springbootdemo
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

#### Notes
- Always provide a default no-args constructor for the model mapping classes - entity and DTO classes.
- Always provide getters and setters for the entity and DTO classes for the ModelMapper to function correctly.
- Try to create a @ControllerAdvice class to handle exceptions - this would centralize all exception handling.
- Always prefer DTO classes to interact with the external world from the AP layer.
- Using a DTO class shields us from changes to the entities in the application.
- Handling of DTO objects(including conversions to/from entity objects) should be done only at the controller layer.