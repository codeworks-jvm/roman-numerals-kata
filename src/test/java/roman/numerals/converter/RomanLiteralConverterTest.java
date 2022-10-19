package roman.numerals.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import roman.numerals.converter.exception.IllegalLiteralException;
import roman.numerals.converter.exception.UnknownLiteralException;
import roman.numerals.converter.parser.RomanLiteralsParser;
import roman.numerals.converter.parser.RomanParser;
import roman.numerals.converter.validator.RomanLiteralValidator;
import roman.numerals.converter.validator.RomanValidator;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @MethodSource("exceptionCases")
    void should_throw_exception_when_roman_literals_are_not_valid(String input, Class<Exception> expectedExceptionClass) {
        assertThrows(expectedExceptionClass, () -> romanLiteralConverter.convert(input));
    }

    @ParameterizedTest
    @CsvSource({
            "I,         1",
            "X,        10",
            "C, 100",
            "XXXIV,    34"
    })
    void should_convert_romain_literal_to_arabic_numbers(String romanLiteral, int conversion) {
        assertThat(romanLiteralConverter.convert(romanLiteral)).isEqualTo(conversion);
    }

    private static Stream<Arguments> exceptionCases() {
        return Stream.of(
                Arguments.of("", IllegalLiteralException.class),
                Arguments.of(null, IllegalLiteralException.class),
                Arguments.of("IZOLC", UnknownLiteralException.class),
                Arguments.of("IIIXXXCCCC", IllegalLiteralException.class));
    }
}