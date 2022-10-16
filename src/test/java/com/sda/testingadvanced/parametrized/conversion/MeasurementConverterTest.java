package com.sda.testingadvanced.parametrized.conversion;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

class MeasurementConverterTest {

	@ParameterizedTest
	@EnumSource
	void shouldConvertToDoubleWithBoundaries(ConversionType conversionType) {
		MeasurementConverter converter = new MeasurementConverter();
		double actual = converter.convert(10.0, conversionType);

		assertTrue(actual < Double.MAX_VALUE);
		assertTrue(actual > Double.MIN_VALUE);
		assertNotEquals(actual, Double.NaN);
	}

	@ParameterizedTest
	@EnumSource(value = ConversionType.class,
	names = {"METERS_TO_YARDS", "INCHES_TO_CENTIMETERS", "MILES_TO_KILOMETERS"})
	void shouldConvertToHigherValue(ConversionType conversionType) {
		MeasurementConverter converter = new MeasurementConverter();
		double value = new Random().nextDouble();
		double convert = converter.convert(value, conversionType);
		assertTrue(convert > value);
	}
}