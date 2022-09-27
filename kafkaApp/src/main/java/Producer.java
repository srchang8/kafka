import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) {

        final Logger logger = LoggerFactory.getLogger(Producer.class);

        // Create properties object for Producer
        Properties prop = new Properties();
        prop.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        prop.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        prop.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // Create the Producer
        final KafkaProducer<String, String> producer = new KafkaProducer<String, String>(prop);

        ProducerRecord<String, String> record = new ProducerRecord<>("SteAlexTopic", "key1", "value1");

        producer.send(record);

        producer.flush();
        producer.close();


    }
}
