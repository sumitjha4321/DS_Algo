
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

/**
 * Created by sumit.jha on 06/06/18.
 */
public class SimpleProducer {

    public static void main(String[] args) throws Exception {

        String topicName = "test-two-replica";

        String key = "myFirstKey";
        String value = "hola";


        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topicName, key, value);

        RecordMetadata metadata = producer.send(producerRecord).get();
        producer.close();
        System.out.println("Message sent: metadata = " + metadata);



    }
}
