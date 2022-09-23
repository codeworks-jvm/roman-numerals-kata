package roman.numerals.converter.enumeration;

import lombok.Getter;
import roman.numerals.converter.exception.UnknownLiteralException;

import java.util.Objects;

import static java.util.Arrays.stream;

@Getter
public enum RomanLiteralToNumeralEnum {

    I(1),
    V(5),
    X(10),
    L(50),
    C(100),
    D(500);

    private final int numeralNotation;

    RomanLiteralToNumeralEnum(int numeralNotation) {
        this.numeralNotation = numeralNotation;
    }

    public static RomanLiteralToNumeralEnum fromLiteral(Character literal) {

        return stream(RomanLiteralToNumeralEnum.values())
                .filter(value -> Objects.equals(value.name(), String.valueOf(literal)))
                .findFirst()
                .orElseThrow(() -> new UnknownLiteralException("Literal '" + literal + "' is unknown !"));
    }

    public static void isValid(Character literal) {
        fromLiteral(literal);
    }
}
