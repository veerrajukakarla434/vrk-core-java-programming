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
  
.bg-yellow-light
#fff5b1, $bg-yellow-light
* **So Nothing will happens if we declare we can do all operations and we will get results without any exception, But to get persistence related exceptions we shoud use @Repository and to make our intent is clear we should use @ Service  wherever applicable.**  



  

 
 
 
  
  
 