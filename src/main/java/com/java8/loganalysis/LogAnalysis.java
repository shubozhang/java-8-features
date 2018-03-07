package com.java8.loganalysis;

import com.java8.loganalysis.model.ApacheLog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shubo.zhang on 7/1/2016.
 */
public class LogAnalysis {

    private static final Map<String, Integer> MONTH_MAP = createMap();

    private static Map<String, Integer> createMap() {
        Map<String, Integer> monthMap = new HashMap<>();
        monthMap.put("Jan", 1);
        monthMap.put("Feb", 2);
        monthMap.put("Mar", 3);
        monthMap.put("Apr", 4);
        monthMap.put("May", 5);
        monthMap.put("Jun", 6);
        monthMap.put("Jul", 7);
        monthMap.put("Aug", 8);
        monthMap.put("Sep", 9);
        monthMap.put("Oct", 10);
        monthMap.put("Nov", 11);
        monthMap.put("Dec", 12);

        return Collections.unmodifiableMap(monthMap);
    }


    public static void main(String[] args) {
        Instant start = Instant.now();

        List<String> rawLogs = getRawLogs();

        List<ApacheLog> logs = cleanLog(rawLogs);

        Map<String,Long> topPath = getTopPath(logs);

        System.out.println("Top ten paths:");
        topPath.entrySet().stream()
                .limit(10)
                .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));

        Instant end = Instant.now();
        System.out.println("\n Time elapsed: " + Duration.between(start,end).toMillis() + " ms");
    }

    private static List<String> getRawLogs() {
        List<String> rawLogs = new ArrayList<>();
        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(LogAnalysis.class.getResourceAsStream("/access_log_Aug95")));
                Stream<String> stream = reader.lines();
        ) {

            stream.map(
                    line -> {
                        rawLogs.add(line);
                        return rawLogs;
                    })
                    .count();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        return rawLogs;
    }


    private static List<ApacheLog> cleanLog(List<String> rawLogs) {
        List<ApacheLog> logs = new ArrayList<>();
        Function<String, ApacheLog> mapper = input -> {
            ApacheLog apacheLog = new ApacheLog();

            Pattern hostPattern = Pattern.compile("^([^\\s]+\\s)");
            Pattern datePattern = Pattern.compile("^.*\\[(\\d\\d/\\w{3}/\\d{4}:\\d{2}:\\d{2}:\\d{2} -\\d{4})]");
            Pattern pathPattern = Pattern.compile("^.*\"\\w+\\s+([^\"]*)\"");
            Pattern statusPattern = Pattern.compile("^.*\"\\s+([^\\s]+)");
            Pattern sizePattern = Pattern.compile("^.*\\s+(\\d+)$");

            Matcher hostMatcher = hostPattern.matcher(input);
            Matcher dateMatcher = datePattern.matcher(input);
            Matcher pathMatcher = pathPattern.matcher(input);
            Matcher statusMatcher = statusPattern.matcher(input);
            Matcher sizeMatcher = sizePattern.matcher(input);

            if (hostMatcher.find()) { apacheLog.setHost(hostMatcher.group(1));}
            if (dateMatcher.find()) {
                int dayOfMonth = Integer.parseInt(dateMatcher.group(1).substring(0,2));
                int month = MONTH_MAP.get(dateMatcher.group(1).substring(3,6));
                int year = Integer.parseInt(dateMatcher.group(1).substring(7,11));
                apacheLog.setDate(LocalDate.of(year,month,dayOfMonth));
            }
            if (pathMatcher.find()) { apacheLog.setPath(pathMatcher.group(1));}
            if (statusMatcher.find()) { apacheLog.setStatus(Integer.parseInt(statusMatcher.group(1)));}
            if (sizeMatcher.find()) { apacheLog.setSize(Integer.parseInt(sizeMatcher.group(1)));}

            return apacheLog;
        };

        Predicate<ApacheLog> validLog = input -> {
            boolean valid = (input.getDate() != null
                            && input.getHost() != null
                            && input.getPath() != null
                            && input.getStatus() != null
                            && input.getSize() != null);
            return valid;
        };

        rawLogs.stream()
                .map(mapper)
                .filter(validLog)
                .forEach(logs::add);

        return logs;
    }

    private static Map<String,Long> getTopPath(List<ApacheLog> logs) {
        Map<String,Long> pathCount = logs.stream()
                .collect(Collectors.groupingBy(ApacheLog::getPath,Collectors.counting()));

        Map<String,Long> topPath = pathCount.entrySet().stream()
                .sorted((entry1,entry2) -> {
                       return entry2.getValue().compareTo(entry1.getValue());
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(e1, e2) -> e2, LinkedHashMap::new));

        return topPath;
    }
}
