## Spring-Cloud: Mcroservices

* Spring Cloud Config Server and Bus
* Load Balancing with Ribbon and Feign
* Implementing Naming Server with Eureka
* Implementing API Gateway with Zuul
* Distributed Tracing with Zipkin
* Fault Tolerance with Hystrix


### What is Spring Cloud? & Why Spring cloud is required?

* Spring Cloud Stream App Starters are Spring Boot based Spring Integration applications that provide integration with external systems.

### Why Spring cloud is required?

* When developing distributed microservices with Spring Boot we face the following issues-

* **Complexity associated with distributed systems-**
  * This overhead includes network issues, Latency overhead, Bandwidth issues, security issues.
* **Service Discovery-**
  * Service discovery tools manage how processes and services in a cluster can find and talk to one another. It involves a directory of services, registering services in that directory, and then being able to lookup and connect to services in that directory.
* **Redundancy-**
  * Redundancy issues in distributed systems.
* **Loadbalancing-**
  * Load balancing improves the distribution of workloads across multiple computing resources, such as computers, a computer cluster, network links, central processing units, or disk drives.
* **Performance issues-**
  * Performance issues due to various operational overheads.
* **Deployment complexities-**
  * Requirement of Devops skills.

### What does one mean by Service Registration and Discovery? How is it implemented in Spring Cloud?


 * When we start a project, we usally have all the configurations in the properties file. As more and more services are developed and deployed, adding and modifying these properties become more complex. Some services might go down, while some the location might change. This manual changing of properties may create issues.
 
* Eureka Service Registration and Discovery helps in such scenarios. As all services are registered to the Eureka server and lookup done by calling the Eureka Server, any change in service locations need not be handled and is taken care of

* **Microservice Registration and Discovery with Spring cloud using Netflix Eureka.**

* Microservice Registration with Spring cloud using Netflix Eureka



#### Overview of Netflix components-

* Spring Cloud Netflix provides Netflix OSS integrations for Spring Boot apps through autoconfiguration and binding to the Spring Environment and other Spring programming model idioms. With a few simple annotations you can quickly enable and configure the common patterns inside your application and build large distributed systems with battle-tested Netflix components. The patterns provided include Service Discovery (Eureka), Circuit Breaker (Hystrix), Intelligent Routing (Zuul) and Client Side Load Balancing (Ribbon).

**Netflix Component Name** |	**Functionality**
----------- | -----------
Eureka	| Service Registration and Discovery
Ribbon	| Dynamic Routing and Load Balancer
Hystrix	| Circuit Breaker
Zuul	| Edge Server

* In this post we develop 2 spring boot microservices named as employee-producer and employee-consumer.
As the name suggests employee-producer will be exposing REST APIs which will be consumed by the employee-consumer.

![sprcloud_1-5](https://www.javainuse.com/sprcloud_1-5.jpg "sprcloud_1-5") 

#### Lets Begin-
* Develop employee-producer as follows- The maven project we will be creating is as follows-

* **pom.xml**

```Java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.javainuse</groupId>
	<artifactId>employee-producer</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.4.1.RELEASE</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>


		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>


</project>

```
* Define the domain class Employee

``` Java
public class Employee {
	private String empId;
	private String name;
	private String designation;
	private double salary;

	public Employee() {
	}
	
	---- setters and getters
}
```
* 
Expose the service using the Controller as-

``` Java
@RestController
public class TestController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}

}
```
* Finally define the Spring Boot Main class

```Java
mport org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}
}

```

* Compile and the run the SpringBootHelloWorldApplication.java as a Java application.	
	
![spring-boot-junit-example](https://www.javainuse.com/spring-boot-junit-example.jpg "spring-boot-junit-example")

*  Develop employee-consumer as follows- The maven project we will be creating is as follows-

* Same above POM.xml file we can use
* Define the controller to consume the service exposed by employee-producer above using the RESTTemplate as follows-

```Java
import java.io.IOException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ConsumerControllerClient {

	public void getEmployee() throws RestClientException, IOException {

		String baseUrl = "http://localhost:8080/employee";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
```
* Finally create the Bean for the above controller, load it and call the getEmployee() Method.

```Java
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.javainuse.controllers.ConsumerControllerClient;

@SpringBootApplication
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(
				SpringBootHelloWorldApplication.class, args);
		
		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		consumerControllerClient.getEmployee();
		
	}
	
	@Bean
	public  ConsumerControllerClient  consumerControllerClient()
	{
		return  new ConsumerControllerClient();
	}
}
```
* **NOTE :** We can use getAPI method instead of getbean


* Running the Rest Client we get the output as

![sprcloud_1-3](https://www.javainuse.com/sprcloud_1-3.jpg "sprcloud_1-3")


* **Develop the Eureka server Service as follows-**
* POM.XML

```Java
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.javainuse</groupId>
	<artifactId>eureka-server</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>eureka-server</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.2.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka-server</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>Camden.SR6</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>

```
* **Define the Spring Boot class with annotations @SpringBootApplication and @EnableEurekaServer.**

```Java
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
```

* Finally specify the port on which the eureka application will get started -
* Next define the batch configuration for creating the tasklet as follows-
* **server.port=8090**
* Run this as java application. Go to URL-  http://localhost:8090/
* We can see the Eureka Server page as follows-

![sprcloud_3-3](https://www.javainuse.com/sprcloud_3-3.jpg "sprcloud_3-3")

* Next we modify the **employee-producer module** we defined previously to register to the Eureka server.

* Add the Spring cloud dependencies to the pom.xml as follows-

```Java
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>
	
<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>Camden.SR6</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
</dependencyManagement>		
```
* Next define the Spring Boot class with annotations @SpringBootApplication and @EnableDiscoveryClient.		
```Java
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}
}
```
* In the application.properties specify the url on which the Eureka server is up and running.
```Java
eureka.client.serviceUrl.defaultZone=http://localhost:8090/eureka
```
* Now start this employee-producer by running this as a Java Application and go to url. http://localhost:8090/
* We can see the Eureka Server page with the **employee-producer** module registered as follows-

![sprcloud_3-4](https://www.javainuse.com/sprcloud_3-4.jpg "sprcloud_3-4")

* **We can see here that the registered application name is coming as UNKNOWN. To change this create in resources a file named bootstrap.properties**
```Java
spring.application.name=employee-producer
```
* We can now see the service registered as-
![sprcloud_3-6](https://www.javainuse.com/sprcloud_3-6.jpg "sprcloud_3-6")

####  What does one mean by Load Balancing ? How is it implemented in Spring Cloud?

* **1. Traditional server side load balancing** 
* Server side load balancing is involved in monolithic applications where we have limited number of application instances behind the load load balancer. We deploy our war/ear files into multiple server instances which are basically a pool of server having the same application deployed and we put a load balancer in front of it.

* Load balancer has a public IP and DNS. The client makes a request using that public IP/DNS. Load balancer decides to which internal application server request will be forwarded to. It mainly use round robin or sticky session algorithm. We call it server side load balancing.

  * 1.1. Problems in microservices architecture
* Mostly server side load balancing is a manual effort and we need to add/remove instances manually to the load balancer to work. So ideally we are loosing the today’s on demand scalability to auto-discover and configure when any new instances will be spinned of.

* Another problem is to have a fail-over policy to provide the client a seamless experience. Finally we need a separate server to host the load balancer instance which has the impact on cost and maintenance.


* **2. Client side load balancing**
* To overcome the problems of traditional load balancing, client side load balancing came into picture. They reside in the application as inbuilt component and bundled along with the application, so we don’t have to deploy them in separate servers.

* Now let’s visualize the big picture. In microservice architecture, we will have to develop many microservices and each microservice may have multiple instances in the ecosystem. To overcome this complexity we have already one popular solution to use service discovery pattern. In spring boot applications, we have couple of options in the service discovery space such as eureka, consoul, zookeeper etc.

* Now if one microservice wants to communicate with another microservice, it generally looks up the service registry using discovery client and Eureka server returns all the instances of that target microservice to the caller service. Then it is the responsibility of the caller service to choose which instance to send request.

* Here the client side load balancing comes into picture and automatically handles the complexities around this situation and delegates to proper instance in load balanced fashion. Note that we can specify the load balancing algorithm to use.


* **3. Netflix ribbon – Client side load balancer**
* Netflix ribbon from Spring Cloud family provides such facility to set up client side load balancing along with the service registry component. Spring boot has very nice way of configuring ribbon client side load balancer with minimal effort. It provides the following features

* Load balancing
* Fault tolerance
* Multiple protocol (HTTP, TCP, UDP) support in an asynchronous and reactive model
* Caching and batching
* To get ribbon binaries, go to maven central. Here is an example to add dependency in Maven:
```Java
pom.xml
<dependency>
    <groupId>com.netflix.ribbon</groupId>
    <artifactId>ribbon</artifactId>
    <version>2.2.2</version>
</dependency>
```

* We will create the following components and see how the whole eco system coordinates in distributed environment.

* Two microservices using Spring boot. One needs to invoke another as per business requirement
* Eureka service registry server
* Ribbon in the invoking microservice to call the other service in load balanced fashion WITH service discovery
* Invoking service in load balanced manner WITHOUT service discovery
* **4.2. Create backend microservice**
* We will create a simple microservice using Spring boot and will expose oe simple REST endpoint. Create one simple spring boot project named ribbon-server with spring-boot-web and service discovery client dependency for hosting this in web server and expose one Rest Controller to test.

* To do this we need to go to https://start.spring.io/ and give the maven coordinates and select dependencies. Download the zip file containing the skeleton project. Then we need to import that in eclipse once unzipped in suitable folder.


