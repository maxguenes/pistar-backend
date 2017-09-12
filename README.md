# pistar-backend
  
  This is the piStar backend Service. Its provides RESTful Services for piStar modeling tool. Its provides the methods:
  - Save model JSON
  - Recover model JSON
  - Service version
  
   The piStar tool can be found at:
   
   [piStar](https://github.com/jhcp/piStar)

  Its requires:
  - Java 8
  - Maven 3
  
  To build you must use Maven command
  - mvn install
  
  The Jar artifacts will be created in the target folder, on each project. The pistar-rest is the web service application and uses Spring Boot frameworks to run. 
  You can run the application using one of those commands:
  - mvn spring-boot:run
  
  or
  
  - java -jar pistar-rest-1.0.0.jar
  
  The applications properties can be override by creating a copy of the [application.properties](https://github.com/maxguenes/pistar-backend/blob/master/pistar-rest/src/main/resources/application.properties) file in the same folder of the Jar artifact, or change those properties and build the project.

  Feel free to add new features to this service.
