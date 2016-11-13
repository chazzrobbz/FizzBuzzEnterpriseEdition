package com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.math.arithmetics;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.ApplicationContextHolder;
import javax.annotation.PostConstruct;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.seriouscompany.business.java.fizzbuzz.packagenamingpackage.impl.strategies.comparators.integercomparator.IntegerForEqualityComparator;

/**
 *  Verifier for NumberIsMultipleOfAnotherNumber
 */
@Service
public class NumberIsMultipleOfAnotherNumberVerifier {

	private static IntegerDivider integerDivider;

	/**
	 * @return void
	 */
	@PostConstruct
	public void init() {
		final ApplicationContext applicationContext = ApplicationContextHolder.getApplicationContext();
		this.integerDivider = applicationContext.getBean(IntegerDivider.class);
	}

	/**
	 * @param nFirstNumber int
	 * @param nSecondNumber int
     * @return
     */
	public static boolean numberIsMultipleOfAnotherNumber(final int nFirstNumber, final int nSecondNumber) {
		try {
			final int nDivideFirstIntegerBySecondIntegerResult =
					(NumberIsMultipleOfAnotherNumberVerifier.integerDivider.divide(nFirstNumber, nSecondNumber));
			final int nMultiplyDivisionResultBySecondIntegerResult =
					nDivideFirstIntegerBySecondIntegerResult * nSecondNumber;
			if (IntegerForEqualityComparator.areTwoIntegersEqual(nMultiplyDivisionResultBySecondIntegerResult,
					nFirstNumber)) {
				return true;
			} else {
				return false;
			}
		} catch (final ArithmeticException ae) {
			return false;
		}
	}

}
