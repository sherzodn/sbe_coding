package com.interview.wordcount;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CountingWordTest {
    private ExecutorService executor1;
    private ExecutorService executor2;
    private ExecutorService executor3;
    private CountingWord countingWord;
    private CountDownLatch countDownLatch;
    private int total1;
    private int total2;
    private int total3;


    void setUp() {
        total1 = 100000;
        total2 = 100000;
        total3 = 100000;
        countingWord = new CountingWord();
        executor1 = Executors.newFixedThreadPool(20);
        executor2 = Executors.newFixedThreadPool(20);
        executor3 = Executors.newFixedThreadPool(20);
        countDownLatch = new CountDownLatch(total1 + total2 + total3);

    }

    @Test
    public void getZeroWhenEmptyMap(){
        countingWord = new CountingWord();
        assertEquals(0, countingWord.getCount("word1"));
    }

    @Test
    void testAddWord() throws InterruptedException {
        //Arrange
        setUp();

        //Act
        addWordsInThreeExecutorPool();

        //Assert
        assertEquals(total1, countingWord.getCount("word1"));
        assertEquals(total2, countingWord.getCount("word2"));
        assertEquals(total3, countingWord.getCount("word3"));
    }


    private void addWordsInThreeExecutorPool() throws InterruptedException {
        for (int i = 0; i < total1; i++) {
            executor1.execute(() -> countingWord.addWord("word1"));
            countDownLatch.countDown();
        }
        for (int i = 0; i < total2; i++) {
            executor2.execute(() -> countingWord.addWord("word2"));
            countDownLatch.countDown();
        }
        for (int i = 0; i < total3; i++) {
            executor3.execute(() -> countingWord.addWord("word3"));
            countDownLatch.countDown();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw e;
        }

        executor1.shutdown();
        executor2.shutdown();
        executor3.shutdown();
    }
}