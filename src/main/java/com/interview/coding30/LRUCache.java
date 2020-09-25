package com.interview.coding30;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final Map<K, V> map;

    public LRUCache(int cacheSize) {
        map = new LinkedHashMap<>(16, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > cacheSize;
            }
        };
    }

    public V get(K key){
        return map.get(key);
    }

    public void set(K key, V value){
        map.put(key, value);
    }

}
