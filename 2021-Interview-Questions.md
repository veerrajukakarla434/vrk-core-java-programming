# 2021-Interview-Questions and Answers

## Kafka Section :

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
