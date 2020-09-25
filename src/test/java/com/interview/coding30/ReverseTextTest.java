package com.interview.coding30;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ReverseTextTest {

    @DisplayName(value = "Reverse test")
    @ParameterizedTest(name = "{index}==> reverse({0}) is {1}")
    @MethodSource("provideArgumentsForReverse")
    void reverse_ShouldReturnReversedStringOrEmptyStringForNullAndEmptyString(String input, String expected) {
        assertEquals(expected, ReverseText.reverse(input));
    }

    private static Stream<Arguments> provideArgumentsForReverse() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of("", ""),
                Arguments.of("a", "a"),
                Arguments.of("1234567890", "0987654321"),
                Arguments.of("abAB", "BAba")
        );
    }
}