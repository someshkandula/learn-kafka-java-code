/*
 * Copyright (c) 2016 Robin Péricé
 * MIT License
 */
package first.example;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class FirstExampleProducer extends Thread {

    private final KafkaProducer<Integer, String> producer;
    private final String topic;

    public FirstExampleProducer(final String topic) {

        final Properties props = new Properties();
        props.put("bootstrap.servers", "raspberrypi:9092");
        props.put("client.id", "DemoProducer");
        props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        this.producer = new KafkaProducer<>(props);
        this.topic = topic;

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
