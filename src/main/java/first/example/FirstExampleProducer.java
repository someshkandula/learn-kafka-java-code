/*
 * Copyright (c) 2016 Robin Perice
 * MIT License
 */
package first.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * This class allows you to push data to a Kafka topic.
 */
public class FirstExampleProducer {

	/** The producer allows to push data to Kafka broker. */
	private KafkaProducer<Integer, String> producer;

	/**
	 * Instantiates the producer with the given properties.
	 *
	 * @param producerProperties
	 *            the consumer properties
	 */
	public FirstExampleProducer(final Properties producerProperties) {
		this.producer = new KafkaProducer<>(producerProperties);
	}

	/**
	 * This method push message to the Kafka topic given in parameter.
	 *
	 * @param topic
	 *            the topic.
	 * @param message
	 *            the message to push into the topic.
	 */
	public void push(final String topic, final String message) {
		producer.send(new ProducerRecord<>(topic, message));
		System.out.println("Producer : message " + message + " sent to topic :" + topic);
	}

}
