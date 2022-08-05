package com.zenika.javabasics.services;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class KTestProducer implements KProducer<String, String> {

    KafkaProducer<String, String> producer;



    @Override
    public void send(String key, String value) {
        producer.send(new ProducerRecord<>(key, value));
    }
}
