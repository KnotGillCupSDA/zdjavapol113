package com.sda.testingadvanced.parametrized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeCheckerTest {

	@ParameterizedTest
	@EmptySource
	@ValueSource(strings = { "TeT", "Tet", "Te T" })
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
	@CsvSource(value = {
			",false",      // null
			"'', true",     // empty
			"' ', true",     // blank
			"TeT, true", "Tet, true", "Te T, true", "abc, false" })
	void testIsPalindrome(String text, boolean expected) {
		assertEquals(expected, PalindromeChecker.isPalindrome(text));
	}


	@ParameterizedTest
	@CsvFileSource(resources = "/palindrome.csv")
	void testIsPalindromeFile(String text, boolean expected) {
		assertEquals(expected, PalindromeChecker.isPalindrome(text));
	}
}