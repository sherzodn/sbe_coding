package com.interview.wordfrequency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequencyUtils {

    public Map<String, Integer> mapWithInteger(String[] countryNames) {
        Map<String, Integer> counterMap = new HashMap<>();
        for (String country : countryNames) {
            counterMap.compute(country, (k, v) -> v == null ? 1 : v + 1);
        }
        return counterMap;
    }

    public Map<String, Long> countWithStreamAPI(String[] countryNames) {
        Map<String, Long> counterMap = new HashMap<>();
        Stream.of(countryNames)
                .collect(Collectors.groupingBy(k -> k, () -> counterMap, Collectors.counting()));
        return counterMap;
    }

    public Map<String, Long> countWithParallelStreamAPI(String[] countryNames) {
        Map<String, Long> counterMap = new ConcurrentHashMap<>();
        Stream.of(countryNames).parallel()
                .collect(Collectors.groupingBy( k -> k, () -> counterMap, Collectors.counting()));

        return counterMap;
    }

    public Map<String, int[]> countWithAnPrimitiveIntegerArray(String[] countryNames) {
        Map<String, int[]> countryMap = new HashMap<>();
        for (String country : countryNames) {
            countryMap.compute(country, (k, v) -> v == null ? new int[]{0} : v)[0]++;
        }

        return countryMap;
    }

    public Map<String, MutableInteger> countWithMutableInteger(String[] countryNames) {
        Map<String, MutableInteger> countryMap = new HashMap<>();
        for (String country : countryNames) {
            countryMap.compute(country, (k, v) -> v == null ? new MutableInteger() : v).increment();
        }
        return countryMap;
    }


    public static class MutableInteger {
        int count = 0;

        public void increment() {
            this.count++;
        }

        public int getCount() {
            return count;
        }
    }


}
