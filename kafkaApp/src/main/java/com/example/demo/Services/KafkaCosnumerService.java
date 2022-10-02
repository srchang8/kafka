package com.example.demo.Services;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

//ToDo: static for testing, then background service
public class KafkaCosnumerService {

    public static void main(String[] args){
        final Logger logger = LoggerFactory.getLogger(KafkaCosnumerService.class);

        final String bootstrapServers =  "127.0.0.1:9092";
        final String GroupID = "test-group";

        Properties properties = new Properties();
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, GroupID);
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        final KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList("SteAlexTopic"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(5000));
            for (ConsumerRecord record: records){
                logger.info("Received new record: \n" +
                        "Key: " + record.key() + ", " +
                        "Value" + record.value() + ", " +
                        "Topic" + record.topic() + ", " +
                        "Partition" + record.partition() + ", " +
                        "Offset" + record.offset() + "\n");
            }
        }
    }
}
