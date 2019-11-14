package com.java8.ch02.streamandcollectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * Created by shubo.zhang on 6/17/2016.
 */
public class Stream04Aggregations {

    public static void main(String[] args) {

        aggregation01();

        aggregation02();

    }

    private static  void aggregation01(){
        Integer id = 0;
        BinaryOperator<Integer> sum = (i1, i2) -> i1 + i2;

        Stream<Integer> stream1 = Stream.empty();
        int red1 = stream1.reduce(id, sum);
        System.out.println("EX01: red1 is " + red1);

        Stream<Integer> stream2 = Stream.of(10);
        int red2 = stream2.reduce(id, sum);
        System.out.println("EX01: red2 is " + red2);

        Stream<Integer> stream3 = Stream.of(10,9,8,7);
        int red3 = stream3.reduce(id, sum);
        System.out.println("EX01: red3 is " + red3);
    }

    /* No identity element for the max reduction operation
    *  So the max of an empty Stream is undefined...
    *
    *  Optional means there might be no result (null)
    * */
    private static void aggregation02() {
        //BinaryOperator<Integer> max = (i1, i2) -> i1 > i2 ? i1 : i2;

        List<Integer> ages = Arrays.asList(23,41,12);
        Stream<Integer> stream = ages.stream();

        Optional<Integer> max = stream.max(Comparator.naturalOrder());
        System.out.println("EX02: max of stream is " + max.get());

    }


}
