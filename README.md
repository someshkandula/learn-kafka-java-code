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
* Launch Zookeeper : ```bin/zookeeper-server-start.sh config/zookeeper.properties &```
* Launch Kafka : ```bin/kafka-server-start.sh config/server.properties &```
