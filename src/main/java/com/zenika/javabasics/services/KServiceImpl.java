package com.zenika.javabasics.services;

public class KServiceImpl<T> implements KService<T> {

    private final KProducer<String, T> producer;

    public KServiceImpl(KProducer<String, T> producer) {
        this.producer = producer;
    }

    @Override
    public void send(T t) {
        producer.send("key", t);
    }
}
