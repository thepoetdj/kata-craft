package dev.thepoetdj.kata.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTests {
    Calculator sut;

    @BeforeEach
    void initialize() {
        sut = new Calculator();
    }

    @ParameterizedTest
    @CsvSource("'',0")
    void addNumbersSeparatedByComma(String numbers, int result) {
        assertEquals(result, sut.add(numbers));
    }
}
