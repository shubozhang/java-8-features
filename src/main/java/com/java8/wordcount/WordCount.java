package com.java8.wordcount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shubo.zhang on 6/29/2016.
 */
public class WordCount {

    public static void main(String[] args) {

        Instant start = Instant.now();

        List<String> rawWords = new ArrayList<>();

        try (
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(WordCount.class.getResourceAsStream("/Shakespeare.txt")));
                Stream<String> stream = reader.lines();
        ) {

            stream.map(
                    line -> {
                        line = line.replaceAll("[^A-Za-z0-9 ]+", "").toLowerCase().trim();
                        String[] s = line.split(" ");
                        List<String> lineWord = Arrays.asList(s);
                        rawWords.addAll(lineWord);
                        return rawWords;
                    }).count();

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        List<String> words = rawWords.stream()
                .filter(word -> !"".equals(word))
                .collect(Collectors.toList());

        Function<String, String> mapper = input -> String.valueOf(input);
        Map<String, Long> wordCount = words.stream()
                .collect(Collectors.groupingBy(mapper, Collectors.counting()));

        wordCount.entrySet().stream()
                .sorted((entry1, entry2) -> { return entry2.getValue().compareTo(entry1.getValue());})
                .limit(20)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        Instant end = Instant.now();
        System.out.println("Time Elapsed: " + Duration.between(start, end).toMillis() +  " ms");
    }
}
