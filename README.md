[![GitHub license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/r0perice/learn-storm-fr/blob/master/LICENSE) [![Kafka Version](https://img.shields.io/badge/Kafka%20API-0.9.0.1-green.svg)](https://kafka.apache.org/090/javadoc/index.html?org/apache/kafka/clients/)


## Quickstart

**Requirements**

Make sure you have java (last version recommended) installed on you machine.

**Step 1** : Install Kafka  
* Download last Kafka release : [**here**](http://apache.websitebeheerjd.nl/kafka/0.9.0.1/kafka_2.11-0.9.0.1.tgz).
* Move the downloaded archive where you want to store Kafka and do :
```
tar -xvf kafka_2.11-0.9.0.1.tgz
cd kafka_2.11-0.9.0.1/
```

**Step 2** : Start Kafka server

* Launch Zookeeper : ```bin/zookeeper-server-start.sh config/zookeeper.properties```
* Launch Kafka : ```bin/kafka-server-start.sh config/server.properties```

If everything is ok, you should see something like that.
>[2016-04-22 18:55:21,792] INFO [Kafka Server 0], started (kafka.server.KafkaServer)

**Useful commands**

* Delete a topic : ```bin/kafka-topics.sh --zookeeper localhost:2181 --delete -topic topic.name ``` (of course you need to adapt zookeeper ip address and topic name to match with you configuration).
* Delete offsets  : ```rm -rf /tmp/__consumer_offsets*```.

## Kafka overview

#### Introduction

Kafka is a messaging system that have partitionning, replication, persistancy properties. His behavior can be summarized as follows. One or more Producer(s) push data on a topic into the Kafka server while Consumers subscribe topics and pull the data from those topics.

![kafka](/images/kafka.png)

#### Topics


See official website for more information ([here](http://kafka.apache.org/)).
