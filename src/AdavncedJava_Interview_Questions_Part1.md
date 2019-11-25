## Spring Boot Interview Questions

#### 1) How can you know or show spring beans created ?

* we can know spring beans created 2 ways
  * 1) Using ApplicationContext
  * 2) Using Actuator
  
* 1) Using ApplicationContext
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
  
 