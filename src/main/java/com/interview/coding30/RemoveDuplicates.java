package com.interview.coding30;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static <E> List<E> removeDuplicates(List<E> list) {
        Set<E> set = new LinkedHashSet<>(list);
        return new ArrayList<>(set);
    }
}
