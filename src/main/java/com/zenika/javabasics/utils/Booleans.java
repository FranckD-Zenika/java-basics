package com.zenika.javabasics.utils;

import java.util.function.Predicate;

public class Booleans {

    public static boolean not(boolean toReverse) {
        return !toReverse;
    }

    public static <T> Predicate<T> not(Predicate<T> toReverse) {
        return toReverse.negate();
    }

    private Booleans() {}
}
