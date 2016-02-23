/*
 * Copyright (c) 2016 Robin Péricé
 * MIT License
 */
package first.example;

import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import kafka.utils.ShutdownableThread;

/**
 * The Class FirstExampleConsumer.
 */
public class FirstExampleConsumer extends ShutdownableThread {

    /** The consumer. */
    private KafkaConsumer<Integer, String> consumer;

    /** The topic. */
    private final String topic;

    /**
     * Instantiates a new first example consumer.
     *
     * @param topic
     *            the topic
     */
    public FirstExampleConsumer(final String topic) {
        super("KafkaConsumerExample", false);
        this.topic = topic;
    }

    @Override
    public void doWork() {
        consumer.subscribe(Collections.singletonList(this.topic));
        final ConsumerRecords<Integer, String> records = consumer.poll(1000);
        for (final ConsumerRecord<Integer, String> record : records) {
            System.out.println(
                    "Received message: (" + record.key() + ", " + record.value() + ") at offset " + record.offset());
        }
    }

    /**
     * Inits the.
     *
     * @param consumerProperties
     *            the consumer properties
     */
    public void init(final Properties consumerProperties) {
        consumer = new KafkaConsumer<>(consumerProperties);
    }

    @Override
    public boolean isInterruptible() {
        return false;
    }

    @Override
    public String name() {
        return null;
    }
}
