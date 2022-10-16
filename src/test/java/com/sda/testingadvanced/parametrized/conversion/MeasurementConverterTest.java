package com.sda.testingadvanced.parametrized.conversion;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}