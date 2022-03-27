
# Kafka
```
cd kafka_2.13-3.1.0

bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties

bin/kafka-topics.sh --create --topic my-topic --bootstrap-server localhost:9092
bin/kafka-topics.sh --describe --topic my-topic --bootstrap-server localhost:9092 

bin/kafka-console-producer.sh --topic my-topic --bootstrap-server localhost:9092
bin/kafka-console-consumer.sh --topic my-topic --from-beginning --bootstrap-server localhost:9092

or docker-case

//Add kafka container id to your hosts
echo "127.0.0.1 7f4655d8fbb3" >> /etc/hosts
```