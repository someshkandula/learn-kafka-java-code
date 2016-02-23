/*
 * Copyright (c) 2016 Robin Péricé
 * MIT License
 */
package first.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * The Class FirstExampleProducer.
 */
public class FirstExampleProducer extends Thread {

    /** The producer. */
    private KafkaProducer<Integer, String> producer;

    /** The topic. */
    private final String topic;

    /**
     * Instantiates a new first example producer.
     *
     * @param topic
     *            the topic
     */
    public FirstExampleProducer(final String topic) {
        this.topic = topic;
    }

    /**
     * Inits the.
     *
     * @param consumerProperties
     *            the consumer properties
     */
    public void init(final Properties consumerProperties) {
        this.producer = new KafkaProducer<>(consumerProperties);
    }

    @Override
    public void run() {
        int messageNumber = 1;
        while (true) {
            final String message = "Message_" + messageNumber;
            producer.send(new ProducerRecord<>(topic, messageNumber, message));
            System.out.println("Sent message: (" + messageNumber + ", " + message + ")");
            ++messageNumber;
        }
    }

}
