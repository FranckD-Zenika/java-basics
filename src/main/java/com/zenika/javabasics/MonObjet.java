package com.zenika.javabasics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonObjet {

    private static final Logger LOGGER = LoggerFactory.getLogger(MonObjet.class);

    private int id;
    private String name;

    private MonObjet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static MonObjet from(int id, String name) {
        LOGGER.warn("a new object is created");
        return new MonObjet(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "MonObjet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
