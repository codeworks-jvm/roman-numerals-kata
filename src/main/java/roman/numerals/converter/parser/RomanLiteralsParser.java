package roman.numerals.converter.parser;

import roman.numerals.converter.enumeration.RomanLiteralToNumeralEnum;

public class RomanLiteralsParser implements RomanParser {

    private static final int START_INDEX_FROM_ZERO = 0;

    public int parse(String romanLiterals) {

        String sanitizedRomanLiterals = sanitizeRomanLiterals(romanLiterals);

        int romanLiteralsLength = sanitizedRomanLiterals.length();

        return parse(sanitizedRomanLiterals, romanLiteralsLength);
    }

    private static int parse(String sanitizedRomanLiterals, int romanLiteralsLength) {
        int numeralSumResult = START_INDEX_FROM_ZERO;

        int startIndex = START_INDEX_FROM_ZERO;

        while (startIndex < romanLiteralsLength) {

            int numeralNotationFromCurrentLiteral = getNumeralNotationFrom(sanitizedRomanLiterals.charAt(startIndex));

            if (isNotTheLastElement(startIndex, romanLiteralsLength)) {

                int numeralNotationFromNextLiteral = getNumeralNotationFrom(sanitizedRomanLiterals.charAt(startIndex + 1));

                if (isToSubtract(numeralNotationFromCurrentLiteral, numeralNotationFromNextLiteral)) {
                    numeralSumResult += numeralNotationFromNextLiteral - numeralNotationFromCurrentLiteral;
                    startIndex += 2;
                } else {
                    numeralSumResult += numeralNotationFromCurrentLiteral;
                    startIndex++;
                }
            } else {
                numeralSumResult += numeralNotationFromCurrentLiteral;
                startIndex++;
            }
        }
        return numeralSumResult;
    }

    private static boolean isToSubtract(int numeralNotationFromCurrentLiteral, int numeralNotationFromNextLiteral) {
        return numeralNotationFromCurrentLiteral < numeralNotationFromNextLiteral;
    }

    private static boolean isNotTheLastElement(int index, int romanLiteralsLength) {
        return index != romanLiteralsLength - 1;
    }

    private static int getNumeralNotationFrom(char literal) {
        return RomanLiteralToNumeralEnum.fromLiteral(literal).getNumeralNotation();
    }

    private static String sanitizeRomanLiterals(String romanLiterals) {
        return romanLiterals.trim();
    }
}
