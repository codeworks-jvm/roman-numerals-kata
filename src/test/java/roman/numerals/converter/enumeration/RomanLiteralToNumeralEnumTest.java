package roman.numerals.converter.enumeration;

import org.junit.jupiter.api.Test;
import roman.numerals.converter.exception.UnknownLiteralException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanLiteralToNumeralEnumTest {

    @Test
    void should_throw_exception_when_literal_is_null() {
        // When - Then
        assertThrows(UnknownLiteralException.class, () -> RomanLiteralToNumeralEnum.fromLiteral(null));
    }

    @Test
    void should_throw_exception_when_literal_is_empty() {
        // When - Then
        assertThrows(UnknownLiteralException.class, () -> RomanLiteralToNumeralEnum.fromLiteral(' '));
    }

    @Test
    void should_throw_exception_when_literal_does_not_match_any_numeral_value() {
        // When - Then
        assertThrows(UnknownLiteralException.class, () -> RomanLiteralToNumeralEnum.fromLiteral('Z'));
    }

    @Test
    void should_return_I_enum_entry_when_literal_value_is_I() {
        // When - Then
        assertLiteralsToNumeralEnum(RomanLiteralToNumeralEnum.fromLiteral('I'), RomanLiteralToNumeralEnum.I);
    }

    @Test
    void should_return_V_enum_entry_when_literal_value_is_V() {
        // When - Then
        assertLiteralsToNumeralEnum(RomanLiteralToNumeralEnum.fromLiteral('V'), RomanLiteralToNumeralEnum.V);
    }

    @Test
    void should_return_X_enum_entry_when_literal_value_is_X() {
        // When - Then
        assertLiteralsToNumeralEnum(RomanLiteralToNumeralEnum.fromLiteral('X'), RomanLiteralToNumeralEnum.X);
    }

    @Test
    void should_return_L_enum_entry_when_literal_value_is_L() {
        // When - Then
        assertLiteralsToNumeralEnum(RomanLiteralToNumeralEnum.fromLiteral('L'), RomanLiteralToNumeralEnum.L);
    }

    @Test
    void should_return_C_enum_entry_when_literal_value_is_C() {
        // When - Then
        assertLiteralsToNumeralEnum(RomanLiteralToNumeralEnum.fromLiteral('C'), RomanLiteralToNumeralEnum.C);
    }

    @Test
    void should_return_D_enum_entry_when_literal_value_is_D() {
        // When - Then
        assertLiteralsToNumeralEnum(RomanLiteralToNumeralEnum.fromLiteral('D'), RomanLiteralToNumeralEnum.D);
    }

    @Test
    void should_return_throw_unknown_literal_exception_when_invalid_literal() {
        // When - Then
        assertThrows(UnknownLiteralException.class, () -> RomanLiteralToNumeralEnum.isValid('A'));
    }

    private void assertLiteralsToNumeralEnum(RomanLiteralToNumeralEnum foundedRomanLiteralToNumeralEnum,
                                             RomanLiteralToNumeralEnum expectedRomanLiteralToNumeralEnum) {

        assertThat(foundedRomanLiteralToNumeralEnum).isEqualTo(expectedRomanLiteralToNumeralEnum);
        assertThat(foundedRomanLiteralToNumeralEnum.getNumeralNotation()).isEqualTo(expectedRomanLiteralToNumeralEnum.getNumeralNotation());
    }

}