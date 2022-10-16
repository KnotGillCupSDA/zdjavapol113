package com.sda.testingadvanced.parametrized.conversion;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.Random;
import java.util.stream.Stream;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

class MeasurementConverterTest {

	private static MeasurementConverter converter;

	@BeforeAll
	static void beforeAll() {
		converter = new MeasurementConverter();
	}

	@ParameterizedTest
	@EnumSource
	void shouldConvertToDoubleWithBoundaries(ConversionType conversionType) {
		double actual = converter.convert(10.0, conversionType);

		assertTrue(actual < Double.MAX_VALUE);
		assertTrue(actual > Double.MIN_VALUE);
		assertNotEquals(actual, Double.NaN);
	}

	@ParameterizedTest
	@EnumSource(value = ConversionType.class, names = { "METERS_TO_YARDS", "INCHES_TO_CENTIMETERS", "MILES_TO_KILOMETERS" })
	void shouldConvertToHigherValue(ConversionType conversionType) {
		double value = new Random().nextDouble();
		double convert = converter.convert(value, conversionType);
		assertTrue(convert > value);
	}

	@ParameterizedTest(name="{index}: {3}")
	@MethodSource("dataProvider")
	void someOperationsShouldBeReversible(ConversionType c1, ConversionType c2, double originalValue, String failureMessage) {
		double actual = converter.convert(converter.convert(originalValue, c1), c2);

		//assertEquals(originalValue, actual, failureMessage);

		assertThat(actual)
				.as(failureMessage)
				.isCloseTo(originalValue, Percentage.withPercentage(0.001));
	}

	public static Stream<Arguments> dataProvider() {
		return Stream.of(
				arguments(
						ConversionType.CENTIMETERS_TO_INCHES,
						ConversionType.INCHES_TO_CENTIMETERS,
						1032849324.0001,
						"Centimeter to inches should be reversible"
				),
				arguments(
						ConversionType.KILOMETERS_TO_MILES,
						ConversionType.MILES_TO_KILOMETERS,
						1,
						"Kilometers to miles should be reversible"),
				arguments(
						ConversionType.KILOMETERS_TO_MILES,
						ConversionType.MILES_TO_KILOMETERS,
						1032849324.0001,
						"Kilometers to miles should be reversible"),
				arguments(
						ConversionType.METERS_TO_YARDS,
						ConversionType.YARDS_TO_METERS,
						1032849324.0001,
						"Meters to yards should be reversible")
		);
	}
}