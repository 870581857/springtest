package com.xf.service;


import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Kafkatest {

    static Properties props = new Properties();

    static {
        props.put("bootstrap.servers", "192.168.17.128:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }

    public static void sendTest1() {
        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 1; i++)
            producer.send(new ProducerRecord("my-topic", "ff", "hh"));
        producer.close();
    }

    public static void sendTest2() {
        String key = "的防守打法";
        String value = "水电费第三方111";
        ProducerRecord<String, String> record = new ProducerRecord<>("my-topic", key, value);
        Producer<String, String> producer = new KafkaProducer<>(props);
//        try {
//            producer.send(record).get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            producer.send(record,
                    new Callback() {
                        public void onCompletion(RecordMetadata metadata, Exception e) {
                            if (e != null)
                                e.printStackTrace();
                            System.out.println("The offset of the record we just sent is: " + metadata.offset());
                        }
                    }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        sendTest1();
        sendTest2();
    }
}
