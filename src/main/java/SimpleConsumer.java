import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sumit.jha on 15/08/18.
 */
public class SimpleConsumer {
/*
    static class Consumer implements Runnable {
        private Properties properties;
        private String topicName;

        public Consumer(Properties properties, String topicName, String groupName) {
            this.properties = properties;
            this.topicName = topicName;
        }

        @Override
        public void run() {

            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
            consumer.subscribe(Arrays.asList(topicName));

            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("thread = " + Thread.currentThread().getName() + " record = " + record.toString());
                }
            }
        }
    }

    public static void main(String[] args) {
        String topicName = "test-two-replica";
        String groupName = "con-1";

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", groupName);
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            service.submit(new Consumer(properties, topicName, groupName));
        }

    }*/
}
