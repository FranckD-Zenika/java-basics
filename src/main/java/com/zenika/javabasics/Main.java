package com.zenika.javabasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5);
        collection.add(6);
        collection.add(4);
        Collection<Integer> collectionToRetain = new ArrayList<>();
        collectionToRetain.add(1);
        collectionToRetain.add(2);
        collectionToRetain.add(3);
        collectionToRetain.add(4);
        collectionToRetain.add(7);
        collectionToRetain.add(8);
        collection.retainAll(collectionToRetain);
        System.out.println(collection);

        collection.removeIf(integer -> integer != null && integer == 2);
        System.out.println(collection);

        collection
                .stream()
                .peek(System.out::println)
                .map(String::valueOf)
                .map(String::toUpperCase)
                ;



    }

    static void x(Object o, String b) {
        if (o == null || b == null)
            throw new IllegalArgumentException("o and b should not be null");

        if ( o instanceof Map ) {
            log((Map<?, ?>) o, b);
            return;
        }


        System.out.println(o + b);
    }

    static String y(Object o, String b) {
        if (o == null || b == null)
            throw new IllegalArgumentException("o and b should not be null");

        if ( o instanceof Map )
            return log((Map<?, ?>) o, b);

        return o + b;

    }

    private static String log(Map<?, ?> o, String b) {
        return o + b;
    }


    /*
    *
    *
    * A (List<B> bList)
    * List<A> aList;
    * Stream<String> aName =  aList.stream() // Stream<A> Stream de 10 elements
    *   .map(A::getBList) //Stream<List<B>> Stream de 10 elements
    *   .flatMap(Collection::stream) // Stream<B> Stream 10 x 10 elements
    *   .map(B::getNom);
    *
    * Stream<String> bName =  bList.stream() // Stream<A> Stream de 10 elements
    *   .map(A::getBList) //Stream<List<B>> Stream de 10 elements
    *   .flatMap(Collection::stream) // Stream<B> Stream 10 x 10 elements
    *   .map(B::getNom);
    *
    * Stream<String> names = Stream.concat(aName, bName) // Stream<String>
    *       .map(String::toUpperCase);
    *
    * if( aList == null || bList == null )
    *     throw ex;
    *
    * if( condition2 )
    *     throw ex2;
    *
    * return Collection.emptyList();
    *
    * List<String> nom = new ArrayList<>();
    * for(A a : aList)
    *   for (B b : a.bList)
    *     nom.add(b.getNom)
    * return nom;
    *
    * */

}