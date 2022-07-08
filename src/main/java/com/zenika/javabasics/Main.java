package com.zenika.javabasics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

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

        var s = collection
                .stream()
                .peek(System.out::println)
//                .flatMap(i -> Stream.of(i, i*5, i*10))
                .collect(Collectors.toMap(integer -> integer, integer -> integer * 5, Integer::sum));
        System.out.println(collection);
        System.out.println(s);

        var c = collection
                .stream()
                .map(integer -> MonObjet.from(integer, String.valueOf(integer)))
                .collect(Collectors.toMap(MonObjet::getId, Function.identity(), (s1, s2) -> s1));

        var x = Stream.of("a", "b").reduce("", String::concat);
        System.out.println(x);
        // TODO verifier utilité du 3ème paramètre.
        var y = Stream.of("a", "b").reduce(new StringBuilder(),
                StringBuilder::append,
                (stringBuilder, stringBuilder2) -> stringBuilder.append(stringBuilder2.toString()));
        System.out.println(y);
        Collection<String> a = List.of("a", "b", "c");

        var z1 = a.stream().noneMatch("y"::equals);
        var z2 = a.stream().anyMatch("a"::equals);
        var z3 = a.stream().allMatch("a"::equals);
        System.out.println(z1 + ", " + z2 + ", " + z3);

        System.out.println(c);
        System.out.println(c.get(3));

        var collection2 = new ArrayList<MonObjet>();

//        var result = collection2
//                .stream()
//                .filter(not(monObjet -> monObjet.getId() == 3))
//                .findFirst()
//                .orElseThrow(RuntimeException::new);

        var strings = new ArrayList<String>();
        strings.add("a");
        strings.add(null);
        strings.add("d");
        strings.add("");
        strings.add(null);
        strings.add("  ");
        strings.add("e");

        var stringList = strings.stream()
                .filter(isNotNullNorBlank)
                .collect(Collectors.toList());
        System.out.println(stringList);
    }

    private static final Predicate<String> isNotNull = Objects::nonNull;
    private static final Predicate<String> isBlank = String::isBlank;
    private static final Predicate<String> isNotNullNorBlank = isNotNull.and(not(isBlank));

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
