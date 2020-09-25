package com.interview.coding30;

public class ReverseText {
    public static String reverse(String input) {
        if (input == null) {
            return "";
        }
        char[] array = input.toCharArray();
        final var halfLength = array.length / 2;
        for (int i = 0; i < halfLength; i++) {
            var ind = array.length - 1 - i;
            var clipboard = array[i];
            array[i] = array[ind];
            array[ind] = clipboard;
        }
        return String.valueOf(array);
    }
}
