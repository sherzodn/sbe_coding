package com.interview.coding30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

   LRUCache<Integer, Integer> cache = new LRUCache<>(3);

   @Test
   public void evictLeastRecentlyUsed(){
       cache.set(1, 11);
       cache.set(2, 22);
       cache.set(3, 33);
       cache.set(4, 44);

       assertNull(cache.get(1));
       assertEquals(22, cache.get(2));
       assertEquals(33, cache.get(3));
       assertEquals(44, cache.get(4));

       cache.set(5, 55);
       assertNull(cache.get(1));
       assertNull(cache.get(2));
       assertEquals(33, cache.get(3));
       assertEquals(44, cache.get(4));
       assertEquals(55, cache.get(5));


   }
}