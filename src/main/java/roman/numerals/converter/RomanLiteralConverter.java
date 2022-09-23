package roman.numerals.converter;

import roman.numerals.converter.parser.RomanParser;
import roman.numerals.converter.validator.RomanValidator;

public class RomanLiteralConverter {

    private final RomanValidator romanValidator;

    private final RomanParser romanParser;

    public RomanLiteralConverter(RomanValidator romanValidator, RomanParser romanParser) {
        this.romanValidator = romanValidator;
        this.romanParser = romanParser;
    }

    public int convert(String romanLiterals) {

        romanValidator.validate(romanLiterals);

        return romanParser.parse(romanLiterals);
    }
}
