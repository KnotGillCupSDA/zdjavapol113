package com.sda.testingadvanced.parametrized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DivisibilityCheckerTest {

	@Test
	void shouldBeDivisibleBy3() {
		//given
		int number = 6;

		//when
		boolean actual = DivisibilityChecker.isDivisibleBy3(number);

		//then
		Assertions.assertTrue(actual);
	}
}