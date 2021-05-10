# 2021-Interview-Questions and Answers

## Kafka Section :

* **Reference**
* https://github.com/privatevkakarla/project8-vkakarla-springboot-kafka-producer-consumer-service/blob/master/Kafka_ReadMe.md

**Q.1 What is Apache Kafka?**
*  Apache Kafka is a publish-subscribe open source message broker application. 
*  Kafka is a publish-subscribe messaging application which is coded in “Scala”. 
*  It is an open source message broker project which was started by the Apache software. 
*  The design pattern of Kafka is mainly based on the design of the transactional log.

**Q.2 How is the Kafka messaging system different from other messaging framework?**

* Kafka is a messaging framework developed by apache foundation, which is to create the create the messaging system along with can provide fault tolerant cluster along with the low latency system, to ensure end to end delivery.

* Below are the bullet points:

* Kafka is a messaging system, which has provided fault tolerant capability to prevent the message loss. 
* Design on public-subscribe model.
* Kafka cab support both Java and Scala.
* Kafka was originated at LinkedIn and later became an open sourced Apache project in 2011
* Work seamlessly with spark and other big data technology.
* Support cluster mode operation
* Kafka messaging system can be use for web service architecture or big data architecture. 
* Kafka ease to code and configure as compare to other messaging framework.
      Kafka required other component such as the zookeeper to create a cluster and act as a coordination server
      
      
**Q.3 What are the key Features of Kafka?**

* Kafka provide a reliable delivery for messages from sender to receiver apart from that it has other key features as well.

* Kafka is designed for achieving high throughput and fault tolerant messaging services.
* Kafka provides build in patriation called as a Topic.
* Also provide the feature of replication.
* Kafka provides a queue, which can handle the high volume of data and eventually transfer the message from one sender to receiver. 
* Kafka also persisted the message in the disk along with has ability to replicate the messages across the cluster
* Kafka work with zookeeper for coordination and synchronization with other services.
* Kafka has good inbuilt support Apache Spark.
* To utilize all this key feature, we need to configure the Kafka cluster properly along with the zookeeper configuration.   
``` java
@EnableKafka
@Configuration
public class KafkaConfig {
	
	
	@Autowired
	kafkaConfiguration kafkaConfiguration;
	
	
	 @Bean
		KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> kafkaListenerContainerFactory() {
			ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
			factory.setConsumerFactory(consumerFactory());
			factory.setConcurrency(kafkaConfiguration.getMessageConsumerConcurrentWorkerCount());
			factory.getContainerProperties().setPollTimeout(kafkaConfiguration.getMessagePollTimeoutInMillis());
			factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
			return factory;
		}
	
	@Bean
	public ConsumerFactory<Integer, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfigs());
	}
	
	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaConfiguration.getKafkaBootstrapServers());
		props.put(ConsumerConfig.GROUP_ID_CONFIG,"sample-group");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);

		return props;
	}

	
	@Bean
	public ProducerFactory<Integer, String> producerFactory() {
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}
    
    @Bean
	public Map<String, Object> producerConfigs() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConfiguration.getKafkaBootstrapServers());
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		return config;
	}
   
    
    
    @Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		Map<String, Object> producerConfigs = producerConfigs();
		ProducerFactory<String, String> pf = new DefaultKafkaProducerFactory<String, String>(producerConfigs);
		KafkaTemplate<String, String> template = new KafkaTemplate<>(pf);
		return template;
	}
    
}
```

**Q.4 Benefits of using Kafka than other messaging services like JMS, RabbitMQ doesn’t provide?**

* Now a days kafka is a key messaging framework, not because of its features even for reliable transmission of messages from sender to receiver, however, below are the key points which should consider.

* **Reliability** − Kafka provides a reliable delivery from publisher to a subscriber with zero message loss..
* **Scalability** −Kafka achieve this ability by using clustering along with the zookeeper coordination server
* **Durability** −By using distributed log, the messages can persist on disk.
* **Performance** − Kafka provides high throughput and low latency across the publish and subscribe application. 
* Considering the above features Kafka is one of the best options to use in Bigdata Technologies to handle the large volume of messages for a smooth delivery.

* **Mention what is the meaning of broker in Kafka?**
* In Kafka cluster, broker term is used to refer Server.

* **Explain the role of the offset.**
* Messages contained in the partitions are assigned a unique ID number that is called the offset. 
* The role of the offset is to uniquely identify every message within the partition.

* **What is a Consumer Group?**
* Consumer Groups is a concept exclusive to Kafka.  
* Every Kafka consumer group consists of one or more consumers that jointly consume a set of subscribed topics.

* **What is the role of the ZooKeeper?**
* Kafka uses Zookeeper to store offsets of messages consumed for a specific topic and partition by a specific Consumer Group.

* **Is it possible to use Kafka without ZooKeeper?**

* No, it is not possible to bypass Zookeeper and connect directly to the Kafka server. 
* If, for some reason, ZooKeeper is down, you cannot service any client request.

* **Explain the concept of Leader and Follower.**

* Every partition in Kafka has one server which plays the role of a Leader, and none or more servers that act as Followers. 
* The Leader performs the task of all read and write requests for the partition, while the role of the Followers is to passively replicate the leader. 
* In the event of the Leader failing, one of the Followers will take on the role of the Leader. 
* This ensures load balancing of the server.

* **What roles do Replicas and the ISR play?**

* Replicas are essentially a list of nodes that replicate the log for a particular partition irrespective of whether they play the role of the Leader. 
* On the other hand, ISR stands for In-Sync Replicas. 
* It is essentially a set of message replicas that are synced to the leaders.

* **Why are Replications critical in Kafka?**
* Replication ensures that published messages are not lost and can be consumed in the event of any machine error, program error or frequent software upgrades.

#### References :
* https://dzone.com/articles/magic-of-kafka-with-spring-boot
* https://data-flair.training/blogs/kafka-interview-questions/
* https://www.edureka.co/blog/interview-questions/top-apache-kafka-interview-questions-for-beginners/
* https://www.zeolearn.com/interview-questions/kafka
* https://www.knowledgehut.com/interview-questions/kafka
* https://career.guru99.com/top-14-kafka-interview-questions/
* https://intellipaat.com/blog/interview-question/kafka-interview-questions/

## Java8 Section:

* **Reference**
* https://github.com/veerrajukakarla434/vrk-core-java-programming/blob/master/Part5_Java8_CoreJava_Interview_Questions.md
* https://www.geeksforgeeks.org/java-8-stream/   ******
* https://www.simplilearn.com/java-8-interview-questions-and-answers-article
* https://java2blog.com/java-8-interview-questions/
* https://intellipaat.com/blog/interview-question/java-8-interview-questions/
* https://www.interviewbit.com/java-8-interview-questions/
* https://www.journaldev.com/2366/core-java-interview-questions-and-answers
* https://www.baeldung.com/java-8-interview-questions



#### Java8 Programms

* **Refenrence**
* https://www.javaguides.net/2020/04/java-8-stream-sorting-with-comparator.html
* https://mkyong.com/java8/java-8-how-to-sort-a-map/

* **Different ways to sort List of String objects in Ascending order using Java 8 Stream APIs:**
 
``` java
mport java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListSorting {
    public static void main(String[] args) {

        List < String > fruits = new ArrayList < String > ();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        List < String > sortedList = fruits.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(sortedList);

        List < String > sortedList1 = fruits.stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        System.out.println(sortedList1);

        List < String > sortedList2 = fruits.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList2);
    }
}

Output:
[Apple, Banana, Mango, Orange]
[Apple, Banana, Mango, Orange]
[Apple, Banana, Mango, Orange]

```
* **Different ways to sort List of String objects in descending order using Java 8 Stream APIs:**

```java
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListSorting {
    public static void main(String[] args) {

        List < String > fruits = new ArrayList < String > ();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        // descending order
        List < String > sortedList3 = fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sortedList3);

        List < String > sortedList4 = fruits.stream().sorted((o1, o2) -> o2.compareTo(o1)).collect(Collectors.toList());
        System.out.println(sortedList4);
    }
}

Output:
[Orange, Mango, Banana, Apple]
[Orange, Mango, Banana, Apple]
```

* **How to sort an Employee by salary in ascending order using Java 8 Stream APIs:**
```java

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListSorting {
    public static void main(String[] args) {

        // sort employee by salary in ascending order
        List < Employee > employees = new ArrayList < Employee > ();
        employees.add(new Employee(10, "Ramesh", 30, 400000));
        employees.add(new Employee(20, "John", 29, 350000));
        employees.add(new Employee(30, "Tom", 30, 450000));
        employees.add(new Employee(40, "Pramod", 29, 500000));

        List < Employee > employeesSortedList1 = employees.stream()
            .sorted((o1, o2) -> (int)(o1.getSalary() - o2.getSalary())).collect(Collectors.toList());
        System.out.println(employeesSortedList1);

        List < Employee > employeesSortedList2 = employees.stream()
            .sorted(Comparator.comparingLong(Employee::getSalary)).collect(Collectors.toList()); //ascending order
        System.out.println(employeesSortedList2);
    }
}
Output:
[Employee [id=20, name=John, age=29, salary=350000], Employee [id=10, name=Ramesh, age=30, salary=400000], Employee [id=30, name=Tom, age=30, salary=450000], Employee [id=40, name=Pramod, age=29, salary=500000]]
[Employee [id=20, name=John, age=29, salary=350000], Employee [id=10, name=Ramesh, age=30, salary=400000], Employee [id=30, name=Tom, age=30, salary=450000], Employee [id=40, name=Pramod, age=29, salary=500000]]
```

* **How to sort an Employee by salary in descending order using Java 8 Stream APIs:**
```java
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamListSorting {
    public static void main(String[] args) {

        // sort employee by salary in ascending order
        List < Employee > employees = new ArrayList < Employee > ();
        employees.add(new Employee(10, "Ramesh", 30, 400000));
        employees.add(new Employee(20, "John", 29, 350000));
        employees.add(new Employee(30, "Tom", 30, 450000));
        employees.add(new Employee(40, "Pramod", 29, 500000));

        List < Employee > employeesSortedList1 = employees.stream()
            .sorted((o1, o2) -> (int)(o2.getSalary() - o1.getSalary())).collect(Collectors.toList());
        System.out.println(employeesSortedList1);

        List < Employee > employeesSortedList2 = employees.stream()
            .sorted(Comparator.comparingLong(Employee::getSalary).reversed()).collect(Collectors.toList()); //ascending order
        System.out.println(employeesSortedList2);
    }
}
Output:
[Employee [id=40, name=Pramod, age=29, salary=500000], Employee [id=30, name=Tom, age=30, salary=450000], Employee [id=10, name=Ramesh, age=30, salary=400000], Employee [id=20, name=John, age=29, salary=350000]]
[Employee [id=40, name=Pramod, age=29, salary=500000], Employee [id=30, name=Tom, age=30, salary=450000], Employee [id=10, name=Ramesh, age=30, salary=400000], Employee [id=20, name=John, age=29, salary=350000]]
```
* **Java 8 Stream examples to sort a Map, by keys or by values.**
* Steps to sort a Map in Java 8.
  * Convert a Map into a Stream
  * Sort it
  * Collect and return a new LinkedHashMap (keep the order)

```java
Map result = map.entrySet().stream()
    .sorted(Map.Entry.comparingByKey()) 			
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
```
* **By default, Collectors.toMap will returns a HashMap**

* **Sort by Keys**
```java
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByKeyExample {

    public static void main(String[] argv) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Original...");
        System.out.println(unsortMap);

        // sort by keys, a,b,c..., and return a new LinkedHashMap
        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));


        // Not Recommend, but it works.
        //Alternative way to sort a Map by keys, and put it into the "result" map
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result);
        System.out.println(result2);

    }

}
Output


Original...
{a=6, b=5, c=20, d=1, e=7, f=9, g=50, y=8, z=10, m=2, n=99}

Sorted...
{a=6, b=5, c=20, d=1, e=7, f=9, g=50, m=2, n=99, y=8, z=10}
{a=6, b=5, c=20, d=1, e=7, f=9, g=50, m=2, n=99, y=8, z=10}

```
* **Sort by Values**

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortByValueExample {

    public static void main(String[] argv) {

        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("g", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Original...");
        System.out.println(unsortMap);

        //sort by values, and reserve it, 10,9,8,7,6...
        Map<String, Integer> result = unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

                        
        //Alternative way
        Map<String, Integer> result2 = new LinkedHashMap<>();
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

        System.out.println("Sorted...");
        System.out.println(result);
        System.out.println(result2);

    }
}
Output


Original...
{a=6, b=5, c=20, d=1, e=7, f=9, g=50, y=8, z=10, m=2, n=99}

Sorted...
{n=99, g=50, c=20, z=10, f=9, y=8, e=7, a=6, b=5, m=2, d=1}
{n=99, g=50, c=20, z=10, f=9, y=8, e=7, a=6, b=5, m=2, d=1}

```

    
