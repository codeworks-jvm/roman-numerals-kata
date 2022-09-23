package roman.numerals.converter.validator;

import org.apache.commons.lang3.StringUtils;
import roman.numerals.converter.enumeration.RomanLiteralRegexEnum;
import roman.numerals.converter.enumeration.RomanLiteralToNumeralEnum;
import roman.numerals.converter.exception.IllegalLiteralException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RomanLiteralValidator implements RomanValidator {

    private static final Pattern IXC_LITERALS_PATTERN = Pattern.compile(RomanLiteralRegexEnum.IXC_REGEX.getRegex());

    private static final int AT_MOST_OCCURRENCES_OF_VLD_LITERALS = 3;

    public void validate(String romanLiterals) {

        checkBlankLiterals(romanLiterals);

        List<Character> romanLiteralsAsList = romanLiteralsAsList(romanLiterals);

        checkInvalidLiterals(romanLiteralsAsList);

        checkIXCLiteralsNotRepeatedSuccessivelyMoreThanThrice(romanLiterals);

        checkVLDLiteralsNotRepeatedMorThanOnce(romanLiteralsAsList);
    }

    private static void checkBlankLiterals(String romanLiterals) {
        if (StringUtils.isBlank(romanLiterals)) {
            throw new IllegalLiteralException("Roman Literals Can't Be Empty Or Null !");
        }
    }

    private static void checkInvalidLiterals(List<Character> romanLiterals) {
        romanLiterals.forEach(RomanLiteralToNumeralEnum::isValid);
    }

    private static void checkIXCLiteralsNotRepeatedSuccessivelyMoreThanThrice(String romanLiterals) {

        if (IXC_LITERALS_PATTERN.matcher(romanLiterals).matches()) {
            throw new IllegalLiteralException("roman Literal `I` Or `X` Or `C` Can't Be Repeated More Than Thrice !");
        }
    }

    private static void checkVLDLiteralsNotRepeatedMorThanOnce(List<Character> romanLiterals) {

        Map<Character, Integer> vldOccurrences = groupByVLDOccurrences(romanLiterals);

        Integer vldTotalOccurrence = computeTotalOccurrenceOfVLDLiterals(vldOccurrences);

        if (vldTotalOccurrence > AT_MOST_OCCURRENCES_OF_VLD_LITERALS) {
            throw new IllegalLiteralException("roman Literals `V` Or `L` Or `D` Can't Be Repeated More Than Once !");
        }
    }

    private static Map<Character, Integer> groupByVLDOccurrences(List<Character> romanLiterals) {

        Map<Character, Integer> groupingByVLDOccurrences = new HashMap<>();

        romanLiterals.stream()
                .filter(literal -> literal == 'V' || literal == 'L' || literal == 'D')
                .forEach(literal -> {
                    groupingByVLDOccurrences.computeIfPresent(literal, (key, value) -> key + 1);

                    groupingByVLDOccurrences.putIfAbsent(literal, 1);
                });

        return groupingByVLDOccurrences;
    }

    private static Integer computeTotalOccurrenceOfVLDLiterals(Map<Character, Integer> vldOccurrences) {
        return vldOccurrences.values()
                .stream()
                .reduce(0, Integer::sum);
    }

    private static List<Character> romanLiteralsAsList(String romanLiterals) {
        return romanLiterals.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.toList());
    }
}
