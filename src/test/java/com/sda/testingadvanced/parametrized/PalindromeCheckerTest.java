package com.sda.testingadvanced.parametrized;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PalindromeCheckerTest {

	@ParameterizedTest
	@ValueSource(strings = {"", "TeT", "Tet", "Te T"})
	void shouldBePalindrome(String text) {

		//when
		boolean actual = PalindromeChecker.isPalindrome(text);

		//then
		assertTrue(actual);
	}

	@ParameterizedTest
	@ValueSource(strings = {"abc"})
	void shouldNotBePalindrome(String text) {

		//when
		boolean actual = PalindromeChecker.isPalindrome(text);

		//then
		assertFalse(actual);
	}
}