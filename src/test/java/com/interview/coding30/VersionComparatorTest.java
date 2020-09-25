package com.interview.coding30;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class VersionComparatorTest {

    Comparator<String> vnc = new VersionComparator();

    @DisplayName("Compare versions for below cases:")
    @ParameterizedTest(name = "case#{index} : compare(''{0}'', ''{1}'') = {2}")
    @MethodSource("provideArguments")
    public void compareVersions(String version1, String version2, int expected) {
        assertEquals(expected, vnc.compare(version1, version2));
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("14", "14.0", 0),
                Arguments.of("15", "14", 1),
                Arguments.of("15.1", "14.13.10", 1),
                Arguments.of("15.1", "15.1.0", 0),
                Arguments.of("15.1.1", "14.13.10", 1),
                Arguments.of("14.10.55", "14.13", -1),
                Arguments.of("14.10.20", "14.10.55", -1),
                Arguments.of("14.10.55", "14.10", 1),
                Arguments.of("14.10.20", "14.10.20", 0),
                Arguments.of("14.10", "14.10.20", -1)
        );
    }
}