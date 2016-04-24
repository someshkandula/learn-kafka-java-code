/*
 * Copyright (c) 2016 Robin Perice
 * MIT License
 */
package first.example;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * This class allows you to pull data from a Kafka topic.
 */
public class FirstExampleConsumer {

	/** The consumer allows to pull data from Kafka broker. */
	private KafkaConsumer<Integer, String> consumer;

	/**
	 * Instantiates the consumer with the given properties.
	 *
	 * @param consumerProperties
	 *            the consumer properties
	 */
	public FirstExampleConsumer(final Properties consumerProperties) {
		consumer = new KafkaConsumer<>(consumerProperties);
	}

	/**
	 * This method pull data from the Kafka topic given in parameter.
	 *
	 * @param topic
	 *            the topic to pull data from.
	 */
	public void pull(final String topic) {
		// subscribe to the topic
		consumer.subscribe(Collections.singletonList(topic));
		// pull data from topic
		final ConsumerRecords<Integer, String> records = consumer.poll(1000);
		// commit the message consumption
		consumer.commitSync();

		// print the result
		if (records != null) {
			for (final ConsumerRecord<Integer, String> record : records) {
				System.out.println("Consumer : message " + record.value() + " at offset " + record.offset());
			}
		} else {
			System.out.println("No data to pull from the topic " + topic);
		}
	}

}
