package com.sda.testingadvanced.parametrized.fibonacci;

public class FibonacciRecursive {

	public int getFibonacciNumber(int nthTerm) {
		if(nthTerm < 0) {
			throw new IllegalArgumentException("nTherm must be greater or equal to 0");
		}
		if (nthTerm == 0) {
			return 0;
		}
		if (nthTerm == 1) {
			return 1;
		}
		return getFibonacciNumber(nthTerm - 1) + getFibonacciNumber(nthTerm - 2);
	}

}
