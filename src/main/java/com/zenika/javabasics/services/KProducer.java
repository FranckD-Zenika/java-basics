package com.zenika.javabasics.services;

public interface KProducer<K, V> {
    void send(K key,V value);
}
