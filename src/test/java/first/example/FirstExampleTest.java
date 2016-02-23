/*
 * Copyright (c) 2016 Robin Péricé
 * MIT License
 */
package first.example;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.testng.annotations.Test;

/**
 * The Class FirstExampleTest.
 */
public class FirstExampleTest {

    /** The Constant duration. */
    final static long duration = 5000;

    /** The consumer properties. */
    final Properties producerProperties = new Properties();

    /** The consumer properties. */
    final Properties consumerProperties = new Properties();

    /**
     * Prepare test.
     */
    @Test
    public void prepareTest() {

        // producer configuration
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "raspberrypi:9092");
        producerProperties.put(ProducerConfig.CLIENT_ID_CONFIG, "FirstExampleProducer");
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerSerializer");
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        // consumer configuration
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "raspberrypi:9092");
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, "FirstExampleConsumer");
        consumerProperties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        consumerProperties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        consumerProperties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "30000");
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerDeserializer");
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");
    }

    /**
     * Test first example.
     */
    @Test(dependsOnMethods = { "prepareTest" })
    public void testFirstExample() {
        final FirstExampleProducer producerThread = new FirstExampleProducer("topic");
        producerThread.init(producerProperties);
        producerThread.start();

        final FirstExampleConsumer consumerThread = new FirstExampleConsumer("topic");
        consumerThread.init(consumerProperties);
        consumerThread.start();

        final long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < duration) {

        }

        System.exit(0);
    }
}
