package com.sda.testingadvanced.parametrized.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciRecursiveTest {

	@ParameterizedTest
	@MethodSource("fibonacciNumbers")
	void shouldReturnFibonacciNumber(int nthTerm, int expected) {
		FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
		assertEquals(expected, fibonacciRecursive.getFibonacciNumber(nthTerm));
	}

	public static Stream<Arguments> fibonacciNumbers() {
		return Stream.of(
				arguments(0, 0),
				arguments(1, 1),
				arguments(2, 1),
				arguments(3, 2),
				arguments(4, 3),
				arguments(5, 5),
				arguments(6, 8),
				arguments(7, 13),
				arguments(18, 2584),
				arguments(30, 832040)
		);
	}
}