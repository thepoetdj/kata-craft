package dev.thepoetdj.kata.math;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isBlank()) return 0;
        return toNumeric(numbers).sum();
    }

    private IntStream toNumeric(String numbers) {
        return Arrays.stream(splitter(numbers)).mapToInt(Integer::parseInt);
    }

    private String[] splitter(String input) {
        String delimiter = "[\n,]";
        Matcher customDelimiter = Pattern.compile("//(.)\\R(.*)", Pattern.DOTALL)
                .matcher(input);
        if (customDelimiter.matches()) {
            delimiter = customDelimiter.group(1);
            return customDelimiter.group(2).split(delimiter);
        }
        return input.split(delimiter);
    }
}
