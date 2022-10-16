package com.sda.testingadvanced.parametrized;

public class PalindromeChecker {

	public static boolean isPalindrome(String text) {
		String normalized = text.trim().replaceAll(" ", "");
		return new StringBuilder(normalized).reverse().toString().equalsIgnoreCase(normalized);
	}
}
