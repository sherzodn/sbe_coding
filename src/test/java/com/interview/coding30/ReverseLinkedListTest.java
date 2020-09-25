package com.interview.coding30;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {


    @Test
    public void reverseEmptyList(){
        ReverseLinkedList<String> list = new ReverseLinkedList<>();
        list.reverse();
        Assertions.assertEquals("[]", list.toString());
    }

    @Test
    public void reverseOneElementList(){
        ReverseLinkedList<String> list = new ReverseLinkedList<>();
        list.add("a1");
        list.reverse();
        Assertions.assertEquals("[a1]", list.toString());
    }

    @Test
    public void reverseManyElementsList(){
        ReverseLinkedList<String> list = new ReverseLinkedList<>();
        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");
        list.reverse();
        Assertions.assertEquals("[a4->a3->a2->a1]", list.toString());
    }


}