package com.sda.testingadvanced.parametrized.fibonacci;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciSequenceTest {

	@ParameterizedTest
	@MethodSource("provideImplementations")
	void shouldCalculateFibonacciNthElement(FibonacciSequence fibonacciSequence) {
		assertEquals(BigInteger.ZERO, fibonacciSequence.getFibonacciNumber(0));
		assertEquals(BigInteger.ONE, fibonacciSequence.getFibonacciNumber(1));
		assertEquals(BigInteger.ONE, fibonacciSequence.getFibonacciNumber(2));

		assertEquals(new BigInteger("701408733"), fibonacciSequence.getFibonacciNumber(44));
	}

	private static Stream<FibonacciSequence> provideImplementations() {
		return Stream.of(new FibonacciRecursive(), new FibonacciIterative());
	}
}