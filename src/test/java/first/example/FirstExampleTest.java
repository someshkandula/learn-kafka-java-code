/*
 * Copyright (c) 2016 Robin Perice
 * MIT License
 */
package first.example;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * The Class FirstExampleTest.
 */
public class FirstExampleTest {

	/** The consumer. */
	private FirstExampleConsumer consumer;

	/** The producer. */
	private FirstExampleProducer producer;

	/**
	 * Prepare test.
	 */
	@BeforeClass
	public void prepareTest() {

		/** The consumer properties. */
		final Properties producerProperties = new Properties();
		producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		producerProperties.put(ProducerConfig.CLIENT_ID_CONFIG, "FirstExampleProducer");
		producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.IntegerSerializer");
		producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringSerializer");

		producer = new FirstExampleProducer(producerProperties);

		/** The consumer properties. */
		final Properties consumerProperties = new Properties();
		consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "FirstExampleConsumer");
		consumerProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		consumerProperties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
		consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.IntegerDeserializer");
		consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
				"org.apache.kafka.common.serialization.StringDeserializer");

		consumer = new FirstExampleConsumer(consumerProperties);

	}

	@Test(enabled = true)
	private void pushToKafka() {
		String[] messages = { "a", "b", "c", "d", "e" };
		for (String letter : messages) {
			producer.push("topic", letter);
		}
	}

	@Test(enabled = true, dependsOnMethods = { "pushToKafka" })
	private void pullFromKafka() {
		consumer.pull("topic");
	}
}
