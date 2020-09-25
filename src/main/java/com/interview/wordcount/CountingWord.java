package com.interview.wordcount;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Write a program to count words. This program should be threadsafe.
 * Implement two apis
 * 1) void addWord(String word) -> increment count of this word
 * 2) long getCount(String word) -> get count of this word
 * <p>
 * Solution
 * Keep a concurrent map. Key to this map should be word while value should be AtomicLong to update it
 * in threadsafe way
 * <p>
 * Test cases
 * One word updated by many threads
 * Many words updated by many threads
 *
 * @Threadsafe
 */
public class CountingWord {
    private final ConcurrentHashMap<String, AtomicLong> map = new ConcurrentHashMap<>();

    public void addWord(String word) {
        map.compute(word, (k, v) -> v == null ? new AtomicLong(0) : v).getAndIncrement();
    }

    public long getCount(String word) {
        return map.getOrDefault(word, new AtomicLong(0)).longValue();
    }
}
