package dev.thepoetdj.kata.math;

import java.util.Arrays;

public class Calculator {
    private static final String DEFAULT_SEPARATOR = ",";

    public int add(String numbers) {
        if (numbers.isBlank()) return 0;
        return Arrays.stream(numbers.split(DEFAULT_SEPARATOR))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
