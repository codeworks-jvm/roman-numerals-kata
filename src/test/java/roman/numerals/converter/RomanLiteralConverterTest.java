package roman.numerals.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import roman.numerals.converter.exception.IllegalLiteralException;
import roman.numerals.converter.exception.UnknownLiteralException;
import roman.numerals.converter.parser.RomanLiteralsParser;
import roman.numerals.converter.parser.RomanParser;
import roman.numerals.converter.validator.RomanLiteralValidator;
import roman.numerals.converter.validator.RomanValidator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanLiteralConverterTest {

    private RomanLiteralConverter romanLiteralConverter;

    @BeforeEach
    public void setup() {

        RomanValidator romanLiteralValidator = new RomanLiteralValidator();

        RomanParser romanParser = new RomanLiteralsParser();

        romanLiteralConverter = new RomanLiteralConverter(romanLiteralValidator, romanParser);
    }

    @Test
    void should_throw_illegal_literal_exception_when_literals_are_empty() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralConverter.convert(""));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literals_are_null() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralConverter.convert(null));
    }

    @Test
    void should_throw_unknown_literal_exception_when_invalid_literals_are_detected() {
        // When - Then
        assertThrows(UnknownLiteralException.class, () -> romanLiteralConverter.convert("IZOLC"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literal_C_is_repeated_more_than_thrice_successively() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralConverter.convert("IIIXXXCCCC"));
    }

    @Test
    void should_return_1_when_parsing_I() {
        // When - Then
        assertThat(romanLiteralConverter.convert("I")).isEqualTo(1);
    }

    @Test
    void should_return_10_when_parsing_X() {
        // When - Then
        assertThat(romanLiteralConverter.convert("X")).isEqualTo(10);
    }

    @Test
    void should_return_100_when_parsing_C() {
        // When - Then
        assertThat(romanLiteralConverter.convert("C")).isEqualTo(100);
    }

    @Test
    void should_return_34_when_parsing_XXXIV() {
        // When - Then
        assertThat(romanLiteralConverter.convert("XXXIV")).isEqualTo(34);
    }
}