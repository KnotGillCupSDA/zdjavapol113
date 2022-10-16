package com.sda.testingadvanced.parametrized.fibonacci;

import java.math.BigInteger;

public class FibonacciRecursive implements FibonacciSequence {

	@Override
	public BigInteger getFibonacciNumber(int nthTerm) {
		if(nthTerm < 0) {
			throw new IllegalArgumentException("nTherm must be greater or equal to 0");
		}
		if (nthTerm == 0) {
			return BigInteger.ZERO;
		}
		if (nthTerm == 1) {
			return BigInteger.ONE;
		}
		return getFibonacciNumber(nthTerm - 1).add(getFibonacciNumber(nthTerm - 2));
	}

}
