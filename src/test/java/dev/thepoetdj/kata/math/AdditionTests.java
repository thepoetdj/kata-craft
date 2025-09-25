package dev.thepoetdj.kata.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.CsvSources;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTests {
    Calculator sut;

    @BeforeEach
    void initialize() {
        sut = new Calculator();
    }

    @ParameterizedTest
    @CsvSources({
            @CsvSource("'',0"),
            @CsvSource("'1',1"),
            @CsvSource("'1,5',6"),
            @CsvSource("'1,6,7,3,2',19")
    })
    void addNumbersSeparatedByComma(String numbers, int result) {
        assertEquals(result, sut.add(numbers));
    }

    @Test
    void addNumbersSeparatedByNewline() {
        assertEquals(6, sut.add("1\n2,3"));
    }
}
