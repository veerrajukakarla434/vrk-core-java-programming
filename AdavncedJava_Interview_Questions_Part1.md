## Spring Boot Interview Questions

#### 1) How can you know or show spring beans created ?

* we can know spring beans created 2 ways
  * 1) Using ApplicationContext
  * 2) Using Actuator
  
* **Using ApplicationContext**
* Adding ApplicationContent in SpringBoot Main class and In Spring Boot, you can use appContext.getBeanDefinitionNames() to get all the beans loaded by the Spring container.

```Java
package com.vrk.mongodb.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@EnableMongoRepositories(basePackages="com.vrk.mongodb.repo")
@ComponentScan(value="com.vrk.mongodb.*")
@SpringBootApplication
public class VrkMongodbApplication {
	
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(VrkMongodbApplication.class, args);
		displayAllBeans();
	}
   
	 @Bean
	    public Docket saggerapi() {
	        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.vrk.mongodb.controller")).build();
	    }
	 
	 public static void displayAllBeans() {
	        String[] allBeanNames = applicationContext.getBeanDefinitionNames();
	        for(String beanName : allBeanNames) {
	            System.out.println(beanName);
	        }
	    }
}
```
Console Output

```Console

2019-11-25 05:52:30.638  INFO 8980 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 20119 (http) with context path ''
2019-11-25 05:52:30.639  INFO 8980 --- [           main] c.vrk.mongodb.app.VrkMongodbApplication  : Started VrkMongodbApplication in 2.711 seconds (JVM running for 3.145)
org.springframework.context.annotation.internalConfigurationAnnotationProcessor
org.springframework.context.annotation.internalAutowiredAnnotationProcessor
org.springframework.context.annotation.internalCommonAnnotationProcessor
org.springframework.context.event.internalEventListenerProcessor
org.springframework.context.event.internalEventListenerFactory
vrkMongodbApplication
org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory
methodExecutionCalculationAspect
mongoDBEmpController
employeeServiceImpl
serviceModelToSwagger2MapperImpl
vendorExtensionsMapperImpl
parameterMapperImpl
modelMapperImpl
licenseMapperImpl
securityMapperImpl
apiListingReferenceScanner
apiDocumentationScanner
apiDescriptionReader
apiListingReader
cachingOperationReader
mediaTypeReader
apiListingScanner
.....etc.

``` 
  
* **Using Actuator**
* once you added actuator starter in pom.xml

```Java
        <dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
```
* you can see below all provided URLs from actuator http://localhost:8080/actuator.

![actuator](https://github.com/veerrajukakarla434/vrk-core-java-programming/blob/master/resources/images/actuator.JPG)	

* If you click on actuator URL you can see all created/loaded beans
	  
![Beans](https://github.com/veerrajukakarla434/vrk-core-java-programming/blob/master/resources/images/Beans.JPG)	

* If you click on system health to know application health check 

![status](https://github.com/veerrajukakarla434/vrk-core-java-programming/blob/master/resources/images/status.JPG)
  
#### 2) What happened if I use/put @Component on top of Service layer or repo layer ?

 * **With Spring’s auto-scanning feature, it automatically detects various beans defined in our application.** We usually annotate our beans using one of the available Spring annotations – @Component, @Repository, @Service, @Controller.
 * On detecting the bean, Spring simply registers it into the ApplicationContext.
 
* **@Component:**
  * We can use @Component annotation to mark a bean as a Spring-managed component. **In other words, it’s a generic stereotype for any Spring-managed component.**
```Java

@Component
public class Employee {
   ...
  
}
```
* **@Repository:**
* @Repository annotation is a specialization over @Component annotation:  

```Java
@Component
public @interface Repository {
}
```
* Since @Repository is a type of @Component, Spring also auto-scans and registers them.

* **@Repository is a stereotype for the persistence layer. Its job is to catch all persistence related exceptions and rethrow them as a Spring DataAccessException.**
For this, we should configure PersistenceExceptionTranslationPostProcessor in our application context:
```Java
<bean class=
  "org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor"/>
```  
This bean post processor adds an advisor to all beans marked with @Repository. The advisor’s responsibility is to translate the platform-specific exceptions to the Spring’s unified unchecked exceptions.

* **@Service:**
* Just like @Repository, @Service is another specialization of @Component:

```Java
@Component
public @interface Service {
}
```

* Just like @Repository, @Service is also a type of @Component. That means Spring will also automatically detect such beans.

* **The @Service annotation represents that our bean holds some business logic.** Till date, it doesn’t provide any specific behavior over @Component.

* Still, **we should annotate the service-layer beans with the @Service annotation to make our intent clear.** Additionally, we never know if someday Spring chooses to add some specific functionality to it.

#### Differences in NutShell:
* Let’s quickly sum up the differences between @Component, @Repository and, @Service:

  * @Component is the most generic stereotype and marks a bean as a Spring-managed component
  * Both @Service and @Repository annotations are the specializations over the @Component annotation
  * @Repository is a stereotype used for persistence layer. It translates any persistence related exceptions into a Spring’s DataAccessException
  * @Service is used for the beans at the service layer. Currently, it doesn’t offer any additional functionality over @Component
  * It’s always preferable to use @Repository and @Service annotations over @Component, wherever applicable. It communicates the bean’s intent more clearly
```Console
So Nothing will happens if we declare we can do all operations and we will get results without any exception, 
But to get persistence related exceptions we should use @Repository 
and to make our intent is clear we should use @ Service  wherever applicable.  
```

#### 3) What is the difference between @RestController and @Controller

```Console
The @RestController annotation in Spring MVC is nothing but a combination of @Controller and 
@ResponseBody annotation. It was added into Spring 4.0 to make the development of 
RESTful Web Services in Spring framework easier. 
```  
* The job of @Controller is to create a Map of model object and find a view but @RestController simply return the object and object data is directly written into HTTP response as JSON or XML.

* This can also be done with traditional @Controller and use @ResponseBody annotation but since this is the default behavior of RESTful Web services, Spring introduced @RestController which combined the behavior of @Controller and @ResponseBody together.

* 1. The @Controller is a common annotation which is used to mark a class as Spring MVC Controller while @RestController is a special controller used in RESTFul web services and the equivalent of @Controller + @ResponseBody.

* 2. The @RestController is relatively new, added only on Spring 4.0 but @Controller is an old annotation, exists since Spring started supporting annotation, officially it was added on Spring 2.5 version.

* 3. The @Controller annotation indicates that the class is a "Controller" like a web controller while @RestController annotation indicates that the class is a controller where @RequestMapping methods assume @ResponseBody semantics by default i.e. servicing REST API.

* 4. The @Controller is a specialization of @Component annotation while @RestController is a specialization of @Controller annotation. It is actually a convenience controller annotated with @Controller and @ResponseBody as shown below.

* 5. Another key difference between @RestController and @Controller is that you don't need to use @ResponseBody on every handler method once you annotate the class with @RestController as shown below:
 
#### with @RestControler 
 ```Java
@RestController
public class Book{

@RequestMapping(value={"/book"})
public Book getBook(){
//...
return book;
}
}
```
#### without @RestController
```Java
@Controller
public class Book{

@RequestMapping(value={"/book"})
@ResponseBody
public Book getBook(){
//...
return book;
}
}
```

#### 4) How to Disable a Specific Auto-Configuration?

* If we want to disable a specific auto-configuration, we can indicate it using the exclude attribute of the @EnableAutoConfiguration annotation. For instance, this code snippet neutralizes DataSourceAutoConfiguration:

```Java
// other annotations
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
public class MyConfiguration { }
```
* If we enabled auto-configuration with the @SpringBootApplication annotation — which has @EnableAutoConfiguration as a meta-annotation — we could disable auto-configuration with an attribute of the same name:
```Java
// other annotations
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyConfiguration { }
```
* We can also disable an auto-configuration with the spring.autoconfigure.exclude environment property. This setting in the application.properties file does the same thing as before:
```Java
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfigur
```
#### 5)  Why use Spring Boot?

* **A) Spring Boot has many advantages, such as:**
  * Operate independently
  * implified configuration
  * Automatic configuration
  * No code generation and XML configuration
  * Application monitoring
  * Easy to get started
* Reduce development, testing time and effort.
* Using JavaConfig helps avoid using XML.
* Avoid a lot of Maven import and various version conflicts.
* Provide advice development methods.
* Start development quickly by providing default values.
* There is no separate web server required. This means you no longer need to start Tomcat, Glassfish or anything else.
* Less configuration is required because there is no web.xml file. Just add the class annotated with @Configuration and add the method annotated with @Bean. Spring will automatically load the object and manage it as before. You can even add @Autowired to the bean method to have Spring automatically load the required dependencies.
* Environment-based configuration Using these properties, you can pass the environment you are using to the application: -Dspring.profiles.active = {enviornment}. After loading the main application properties file, Spring will load the subsequent application properties file in (application{environment} .properties).
 
#### 6) What are the core configuration files for Spring Boot? What is the difference between them?

* A) The core configuration files for Spring Boot are the **application and bootstrap** configuration files.

* The application configuration file is easy to understand and is primarily used for automated configuration of Spring Boot projects.

* The bootstrap configuration file has the following application scenarios.

* When using Spring Cloud Config to configure the hub, you need to add the configuration properties of the connection to the configuration center in the bootstrap configuration file to load the configuration information of the external configuration center.
* Some fixed attributes that cannot be overridden;
* Some encryption/decryption scenarios;

#### 7) What is Swagger? Did you implement it with Spring Boot?

* A) Swagger is widely used for visual APIs, using the Swagger UI to provide an online sandbox for front-end developers. Swagger is a tool for generating visual representations of RESTful web services, specifications and full framework implementations.

* It enables documents to be updated at the same speed as the server. When properly defined by Swagger, consumers can use a minimal amount of implementation logic to understand and interact with remote services. Therefore, Swagger eliminates the guesswork when calling the service.

#### 8) What is Spring Profiles?

* A) Spring Profiles allows users to register beans based on configuration files (dev, test, prod, etc.). Therefore, when the application is running in development, only certain beans can be loaded, while in PRODUCTION, some other beans can be loaded.

* Suppose our requirement is that the Swagger document is only for the QA environment and all other documents are disabled. This can be done using a configuration file. Spring Boot makes it easy to use configuration files.


## Spring Boot Annotations

* The spring boot annotations are mostly placed in **org.springframework.boot.autoconfigure** and 
**org.springframework.boot.autoconfigure.condition** packages. Let’s learn about some frequently used spring boot 
annotations as well as which work behind the scene.

#### Spring Boot @SpringBootApplication Annotation
* Spring Boot @SpringBootApplication annotation is used to mark a configuration class that declares one or more @Bean methods and also triggers auto-configuration and component scanning. It’s same as declaring a class with @Configuration, @EnableAutoConfiguration and @ComponentScan annotations.

#### 10 Spring MVC and REST annotations for Java developers

**1. @Controller**

* This annotation is used to make a class as web controller, which can handle client requests and send a response back to the client. This is a class level annotation, which is put on top of your controller class. Similar to @Service and @Repository it is also a stereotype annotation. If you are wondering what is the difference between them then you can also see this article to learn more about their differences.

* Here is an example of @Controller annotation in Spring MVC:

```Java
@Controller
public class HelloController{
// handler methods
}
```

**2. @RequestMapping**

* The Controller class contains several handler methods to handle different HTTP request but how does Spring map a particular request to a particular handler method? Well, that's done with the help of the @RequestMapping annotation. It's a method level annotation which is specified over a handler method.

* It provides the mapping between the request path and handler method. It also supports some advanced option which can be used to specify separate handler methods for different types of request on the same URI like you can specify a method to handle GET request and another to handle POST request on same URI.

* Here is an example of @RequestMapping annotation in Spring MVC:

```Java
@Controller
public class HelloControler{

  @RequestMapping("/")
  public String hello(){
    return "Hello Spring MVC";
  }
}

if spring rest
@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST, produces = "application/json")
```
**3. @RequestParam**

* This is another useful Spring MVC annotation which is used to bind HTTP parameters into method arguments of handler methods. For example, if you send query parameters along with URLlikie for paging or just to supply some key data then you can get them as method arguments in your handler methods.

```Java
@RequestMapping("/book")
public String showBookDetails(

@RequestParam("ISBN") String ISBN, Model model){
  model.addAttribute("ISBN", ISBN);
  return "bookDetails";
}
```

* If you access your web application which provides book details with a query parameter like below:

* http://localhost:8080/book?ISBN=900848893

* then above handler method will be called because it is bound to the "/book" URL and the query parameter ISBN will be used to populate the method argument with the same name "ISBN" inside showBookDetails() method.

**4. @PathVariable**
* This is another annotation which is used to retrieve data from the URL. Unlike @RequestParam annotation which is used to extract query parameters, this annotation enables the controller to handle a request for parameterized URLs like URLs that have variable input as part of their path like:

* http://localhost:8080/books/900083838

* If you want to retrieve the ISBN number "900083838" from the URL as method argument then you can use @PathVariable annotation in Spring MVC as shown below:

```Java
@RequestMapping(value="/books/{ISBN}",
                        method= RequestMethod.GET)
public String showBookDetails(@PathVariable("ISBN") String id,
Model model){
   model.addAttribute("ISBN", id);
   return "bookDetails";
}
```

* The Path variable is represented inside curly braces like {ISBN}, which means the part after /books is extracted and populated on method argument id, which is annotated with @PathVaraible.

* In short, this annotation binds placeholder from the URI to a method parameter inside the handler method. This is immensely useful while developing RESTful web services which contains useful data as part of their URL.

**5. @RequestBody**

* This annotation can convert inbound HTTP data into Java objects passed into the controller's handler method. Just as @ResponseBody tells the Spring MVC to use a message converter when sending a response to the client, the @RequestBody annotations tell the Spring to find a suitable message converter to convert a resource representation coming from a client into an object.
```Java
Here is an example:

@RequestMapping(method=RequestMethod.POST, consumers= "application/json")
public @ResponseBody Course saveCourse(@RequestBody Course aCourse){
   return courseRepository.save(aCourse);
}
```
* This is again a very useful annotation while developing RESTful web service in Java using Spring framework and one of the reasons why I love to write RESTful API using Spring.

* If you are also interested in developing RESTful application in Java then I suggest going through Eugen Parachiv's REST with Spring Certification class on Baeldung. He has shared his years of experience in developing REST-based applications using Spring in this course.


**6. @ResponseBody**
* The @ResponseBody annotation is one of the most useful annotations for developing RESTful web service using Spring MVC. This annotation is used to transform a Java object returned from he a controller to a resource representation requested by a REST client. It can completely bypass the view resolution part.

* Here is an example of @ResponseBody annotation in Spring MVC:
```Java
@RequestMapping(method=RequestMethod.POST,consumers= "application/json")
public @ResponseBody Course saveCourse(@RequestBody Course aCourse){
  return courseRepository.save(aCourse);
}
```
* This is the same as the previous example but the @ResponseBody is used to indicate that the response returned by this method will be converted into a resource which the client can consume.

* If you have created any RESTful web service with Spring MVC then you know that we need to annotate each method which generates REST response with the @ResponseBody annotation but with the introduction of @RestController, we can avoid this.




**7. @RestController**
* This is convenience annotation for developing RESTful web service with Spring MVC framework. The @RestController is a combination of @Controller and @ResponseBody, which was introduced in the Spring 3.4 version.

* When you annotate a controller class with @RestController it does two purposes, first, it says that the controller class is handling a request for REST APIs and second you don't need to annotate each method with the @ResposneBody annotation to signal that the response will be converted into a Resource using various HttpMessageConverers.

* Here is an example of @RestController annotation in Spring MVC:
```Java
@RestController
class HelloControler{

@RequestMapping("/")
public String hello(){
  return "Hello Spring Booot";
}

}
```
* You can see that there is no @ReseponseBody annotation is required to generate RESTful response. Before @RestController, Java developer used @Controller on top of the class and annotated each handler method with @ResponseBody annotation.

#### Differences between @RequestParam and @PathVariable in Spring MVC

```Console
Both annotations @RequestParam and @PathVariable in Spring MVC are used for fetching the values of request parameters.
These annotations have similar purpose but some differences in use. 
The key difference between @RequestParam and @PathVariable is that @RequestParam used for accessing
the values of the query parameters where as @PathVariable used for accessing the values from the URI template.
```

## That is the different annotations from Spring and JAX-RS

**SPRING ANNOTATION**|**JAX-RS ANNOTATION**
--------------------|------------------
@RequestMapping(path = “/troopers” | @Path(“/troopers”)
@PostMapping	| @POST
@PutMapping	| @PUT
@GetMapping	| @GET
@DeleteMapping	| @DELETE
@ResponseBody	| N/A
@RequestBody	| N/A
@PathVariable(“id”)	| @PathParam(“id”)
@RequestParam(“xyz”)	| @QueryParam(‘xyz”)
@RequestParam(value=”xyz”)	| @FormParam(“xyz”)
@RequestMapping(produces = {“application/json”}) | 	@Produces(“application/json”)
@RequestMapping(consumes = {“application/json”}) |	@Consumes(“application/json”)

#### Diff between PathParam and QueryParam ?

* Path params are part of the url where as query parameters are added after the ? mark symbol and separated from other query parameters by & symbol.
 
```Java
PathParam example
GET http://base-url/students/{roll-number}  OR

@RequestMapping(path = “/base-url/students/{roll-number}”  == @Path(“/base-url/students/{roll-number}”)

QueryParam example
GET http://base-url/students?grade=10    OR

@RequestMapping(path = “/base-url/students/{roll-number}”  == @Path(“/base-url/students/{roll-number}”)
```

* **When to use @PathParam vs @QueryParam**
* This is not a standard, you can use anyone for designing restful api.

* However, the commonly used convention is :

  * Any required or mandatory attributes should be added as path param
  * Any optional attributes should be added as query param
  * params used for filtering data are usually used as query param
 
Java
Path param example
Finding employee with ID = 12345

GET http://base-url/employees/{12345}


Query param example
Finding active employees with title as developer

GET http://base-url/employees?title=developer&status=active



```

