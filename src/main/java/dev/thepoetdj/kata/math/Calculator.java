package dev.thepoetdj.kata.math;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isBlank()) return 0;
        List<Integer> actualNumbers = toNumeric(numbers);
        List<Integer> negatives = actualNumbers.stream()
                .filter(this::isNegative)
                .toList();
        if (!negatives.isEmpty()) {
            String allNegatives = negatives.toString();
            throw new IllegalArgumentException("negative numbers not allowed "
                    + allNegatives.substring(1, allNegatives.length() - 1));
        }
        return actualNumbers.stream().reduce(Integer::sum).orElse(0);
    }

    private List<Integer> toNumeric(String numbers) {
        return Arrays.stream(splitter(numbers))
                .mapToInt(Integer::parseInt)
                .boxed().toList();
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

    private boolean isNegative(int number) {
        return number < 0;
    }
}
