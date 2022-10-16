package com.sda.testingadvanced.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeCheckerTest {

	@ParameterizedTest
	@ValueSource(strings = { "", "TeT", "Tet", "Te T" })
	void shouldBePalindrome(String text) {

		//when
		boolean actual = PalindromeChecker.isPalindrome(text);

		//then
		assertTrue(actual);
	}

	@ParameterizedTest
	@ValueSource(strings = { "abc" })
	void shouldNotBePalindrome(String text) {

		//when
		boolean actual = PalindromeChecker.isPalindrome(text);

		//then
		assertFalse(actual);
	}

	@ParameterizedTest
	@CsvSource(value = { "TeT, true", "Tet, true", "Te T, true", "abc, false" })
	void testIsPalindrome(String text, boolean expected) {
		assertEquals(expected, PalindromeChecker.isPalindrome(text));
	}
}