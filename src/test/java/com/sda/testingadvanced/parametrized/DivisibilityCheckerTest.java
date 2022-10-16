package com.sda.testingadvanced.parametrized;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DivisibilityCheckerTest {

	@ParameterizedTest
	@ValueSource(ints = {6, 12, -3, 0, 82366794})
	void shouldBeDivisibleBy3(int number) {

		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(number);

		//then
		assertTrue(actual);
	}

	@Test
	void shouldNotBeDivisibleBy3() {
		//given
		int number = 7;

		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(number);

		//then
		assertFalse(actual);
	}
}