package com.zenika.javabasics;

public class MonObjet {
    private int id;
    private String name;

    private MonObjet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static MonObjet from(int id, String name) {
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
