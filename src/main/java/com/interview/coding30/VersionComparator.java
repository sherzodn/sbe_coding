package com.interview.coding30;

import java.util.Arrays;
import java.util.Comparator;

public class VersionComparator implements Comparator<String> {

    @Override
    public int compare(String version1, String version2) {
        var array1 = Arrays.stream(version1.split("\\."))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        var array2 = Arrays.stream(version2.split("\\."))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);
        var length1 = array1.length;
        var length2 = array2.length;
        var ind = 0;
        while (ind < length1 || ind < length2) {
            if (ind < length1 && ind < length2) {
                if (array1[ind] < array2[ind]) {
                    return -1;
                } else if (array1[ind] > array2[ind]) {
                    return 1;
                }
            } else if (ind < length1) {
                if (array1[ind] != 0) {
                    return 1;
                }
            } else {
                if (array2[ind] != 0) {
                    return -1;
                }
            }
            ind++;
        }
        return 0;
    }
}
