package roman.numerals.converter.enumeration;

import lombok.Getter;

@Getter
public enum RomanLiteralRegexEnum {

    IXC_REGEX(".*([IXC])\\1{3,}.*");

    private final String regex;

    RomanLiteralRegexEnum(String regex) {
        this.regex = regex;
    }
}
