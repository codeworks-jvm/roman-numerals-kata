package roman.numerals.converter.parser;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanLiteralsParserTest {

    private final RomanLiteralsParser romanLiteralsParser = new RomanLiteralsParser();

    @Test
    void should_return_1_when_parsing_I() {
        // When - Then
        assertThat(romanLiteralsParser.parse("I")).isEqualTo(1);
    }

    @Test
    void should_return_10_when_parsing_X() {
        // When - Then
        assertThat(romanLiteralsParser.parse("X")).isEqualTo(10);
    }

    @Test
    void should_return_100_when_parsing_C() {
        // When - Then
        assertThat(romanLiteralsParser.parse("C")).isEqualTo(100);
    }

    @Test
    void should_return_2_when_parsing_II() {
        // When - Then
        assertThat(romanLiteralsParser.parse("II")).isEqualTo(2);
    }

    @Test
    void should_return_3_when_parsing_III() {
        // When - Then
        assertThat(romanLiteralsParser.parse("III")).isEqualTo(3);
    }

    @Test
    void should_return_20_when_parsing_XX() {
        // When - Then
        assertThat(romanLiteralsParser.parse("XX")).isEqualTo(20);
    }

    @Test
    void should_return_30_when_parsing_XXX() {
        // When - Then
        assertThat(romanLiteralsParser.parse("XXX")).isEqualTo(30);
    }

    @Test
    void should_return_200_when_parsing_CC() {
        assertThat(romanLiteralsParser.parse("CC")).isEqualTo(200);
    }

    @Test
    void should_return_200_when_parsing_CCC() {
        // When - Then
        assertThat(romanLiteralsParser.parse("CCC")).isEqualTo(300);
    }

    @Test
    void should_return_6_when_parsing_VI() {
        // When - Then
        assertThat(romanLiteralsParser.parse("VI")).isEqualTo(6);
    }

    @Test
    void should_return_65_when_parsing_LXV() {
        // When - Then
        assertThat(romanLiteralsParser.parse("LXV")).isEqualTo(65);
    }

    @Test
    void should_return_16_when_parsing_XVI() {
        // When - Then
        assertThat(romanLiteralsParser.parse("XVI")).isEqualTo(16);
    }

    @Test
    void should_return_4_when_parsing_IV() {
        // When - Then
        assertThat(romanLiteralsParser.parse("IV")).isEqualTo(4);
    }

    @Test
    void should_return_159_when_parsing_CLIX() {
        // When - Then
        assertThat(romanLiteralsParser.parse("CLIX")).isEqualTo(159);
    }

    @Test
    void should_return_29_when_parsing_XXIX() {
        // When - Then
        assertThat(romanLiteralsParser.parse("XXIX")).isEqualTo(29);
    }

    @Test
    void should_return_40_when_parsing_XL() {
        // When - Then
        assertThat(romanLiteralsParser.parse("XL")).isEqualTo(40);
    }

    @Test
    void should_return_45_when_parsing_XLV() {
        // When - Then
        assertThat(romanLiteralsParser.parse("XLV")).isEqualTo(45);
    }

    @Test
    void should_return_14_when_parsing_XIV() {
        // When - Then
        assertThat(romanLiteralsParser.parse("XIV")).isEqualTo(14);
    }

    @Test
    void should_return_34_when_parsing_XXXIV() {
        // When - Then
        assertThat(romanLiteralsParser.parse("XXXIV")).isEqualTo(34);
    }

    @Test
    void should_return_145_when_parsing_CXLV() {
        // When - Then
        assertThat(romanLiteralsParser.parse("CXLV")).isEqualTo(145);
    }

}