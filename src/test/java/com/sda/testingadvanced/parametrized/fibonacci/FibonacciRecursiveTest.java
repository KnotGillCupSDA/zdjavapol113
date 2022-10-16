package com.sda.testingadvanced.parametrized.fibonacci;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciRecursiveTest {

	@ParameterizedTest
	@MethodSource("fibonacciNumbers")
	void shouldReturnFibonacciNumber(int nthTerm, BigInteger expected) {
		FibonacciRecursive fibonacciRecursive = new FibonacciRecursive();
		assertEquals(expected, fibonacciRecursive.getFibonacciNumber(nthTerm));
	}

	public static Stream<Arguments> fibonacciNumbers() {
		return Stream.of(
				arguments(0, BigInteger.ZERO),
				arguments(1, BigInteger.ONE),
				arguments(2, BigInteger.ONE),
				arguments(3, BigInteger.valueOf(2)),
				arguments(4, BigInteger.valueOf(3)),
				arguments(5, BigInteger.valueOf(5)),
				arguments(6, BigInteger.valueOf(8)),
				arguments(7, BigInteger.valueOf(13)),
				arguments(18, BigInteger.valueOf(2584)),
				arguments(30, BigInteger.valueOf(832040)),
				arguments(44, BigInteger.valueOf(701408733)),
				arguments(50, new BigInteger("12586269025"))
		);
	}
}