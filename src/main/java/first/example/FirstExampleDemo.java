/*
 * Copyright (c) 2016 Robin Péricé
 * MIT License
 */
package first.example;

public class FirstExampleDemo {
    public static void main(final String[] args) {
        final FirstExampleProducer producerThread = new FirstExampleProducer("topic");
        producerThread.start();

        final FirstExampleConsumer consumerThread = new FirstExampleConsumer("topic");
        consumerThread.start();

    }

}
