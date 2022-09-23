package roman.numerals.converter.validator;

import org.junit.jupiter.api.Test;
import roman.numerals.converter.exception.IllegalLiteralException;
import roman.numerals.converter.exception.UnknownLiteralException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanLiteralValidatorTest {

    private final RomanLiteralValidator romanLiteralValidator = new RomanLiteralValidator();

    @Test
    void should_throw_illegal_literal_exception_when_literals_are_empty() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate(""));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literals_are_null() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate(null));
    }

    @Test
    void should_throw_unknown_literal_exception_when_invalid_literals_are_detected() {
        // When - Then
        assertThrows(UnknownLiteralException.class, () -> romanLiteralValidator.validate("EIXC"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literal_I_is_repeated_more_than_thrice_successively() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("IIIIXC"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literal_X_is_repeated_more_than_thrice_successively() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("IIIXXXXCC"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literal_C_is_repeated_more_than_thrice_successively() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("IIIXXXCCCC"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literal_V_is_repeated_more_than_once() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("VLDD"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literal_L_is_repeated_more_than_once() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("VLLLD"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_literal_D_is_repeated_more_than_once() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("VLDDDD"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_V_literals_appear_more_than_once_in_different_positions() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("XXVCVLID"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_L_literals_appear_more_than_once_in_different_positions() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("XXVCLILD"));
    }

    @Test
    void should_throw_illegal_literal_exception_when_D_literals_appear_more_than_once_in_different_positions() {
        // When - Then
        assertThrows(IllegalLiteralException.class, () -> romanLiteralValidator.validate("XXVCLIDD"));
    }
}