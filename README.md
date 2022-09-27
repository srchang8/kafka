# SteAlex Kafka Project

Swagger Link: http://localhost:8081/swagger-ui.html

Docker Commands:
**view logs**

```
docker logs kafkaapp-kafka-1
```

**Create topic: SteAlex-Topic**

```
docker-compose exec kafka kafka-topics.sh \
--create \
--bootstrap-server localhost:9092 \
--replication-factor 1 \
--partitions 1 \
--topic NameOfTopic
```

**Write messages to topic**

```bash

docker-compose exec -it kafka /opt/bitnami/kafka/bin/kafka-console-producer.sh \
    --broker-list localhost:9092 \
    --topic NameOfTopic

```

**View Messages**
```bash

docker-compose exec -it kafka /opt/bitnami/kafka/bin/kafka-console-consumer.sh \
--bootstrap-server localhost:9092 \
--from-beginning \
--topic NameOfTopic

```
