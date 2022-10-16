package com.sda.testingadvanced.parametrized.romannumeral;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class RomanNumeralConverterTest {

	@ParameterizedTest
	@EnumSource
	void shouldConvertBasicValuesToRomanNotation(RomanNumeralConverter.ArabicToRoman arabicToRoman) {
		assertEquals(arabicToRoman.getRoman(), RomanNumeralConverter.romanFor(arabicToRoman.getArabic()));
	}

	@ParameterizedTest
	@CsvSource({"4999, MMMMCMXCIX", "2121,MMCXXI"})
	void shouldConvertComplexValuesToRomanNotation(int arabic, String roman) {
		assertEquals(roman, RomanNumeralConverter.romanFor(arabic));
	}
}