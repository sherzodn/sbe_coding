package com.interview.wordfrequency;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class WordFrequencyUtilsTest {
    String[] COUNTRY_NAMES = {"China", "Australia", "India", "USA", "USSR", "UK", "China",
            "France", "Poland", "Austria", "India", "USA", "Egypt", "China"};
    WordFrequencyUtils wordFrequencyUtils = new WordFrequencyUtils();

    @Test
    public void testMapWithInteger() {
        Map<String, Integer> countryMap = wordFrequencyUtils.mapWithInteger(COUNTRY_NAMES);
        assertEquals(3, countryMap.get("China").intValue());
        assertEquals(2, countryMap.get("India").intValue());
    }

    @Test
    public void testCountWithStreamAPI() {
        Map<String, Long> counterMap = wordFrequencyUtils.countWithStreamAPI(COUNTRY_NAMES);
        assertEquals(3, counterMap.get("China").intValue());
        assertEquals(2, counterMap.get("India").intValue());
    }

   //@Test
    public void testCountWithParallelStreamAPI() throws InterruptedException {
       Map<String, Long> counterMap = wordFrequencyUtils.countWithParallelStreamAPI(COUNTRY_NAMES);
       //Thread.currentThread().join();
       assertEquals(3, counterMap.get("China").intValue());
       assertEquals(2, counterMap.get("India").intValue());
    }

   @Test
    public void testCountWithAnPrimitiveIntegerArray() {
       Map<String, int[]> countryMap = wordFrequencyUtils.countWithAnPrimitiveIntegerArray(COUNTRY_NAMES);
       assertEquals(3, countryMap.get("China")[0]);
       assertEquals(2, countryMap.get("India")[0]);
    }

    @Test
    public void testCountWithMutableInteger() {
        Map<String, WordFrequencyUtils.MutableInteger> countryMap = wordFrequencyUtils.countWithMutableInteger(COUNTRY_NAMES);
        assertEquals(3, countryMap.get("China").getCount());
        assertEquals(2, countryMap.get("India").getCount());
    }
}