/**
  *  Licensed under the Apache License, Version 2.0 (the "License");
  *  you may not use this file except in compliance with the License.
  *  You may obtain a copy of the License at
  *
  *  http://www.apache.org/licenses/LICENSE-2.0
  *
  *  Unless required by applicable law or agreed to in writing, software
  *  distributed under the License is distributed on an "AS IS" BASIS,
  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  *  See the License for the specific language governing permissions and
  *  limitations under the License.
  */
package com.fireflysemantics.math.exception;

import static com.fireflysemantics.math.exception.ExceptionKeys.CONSTRAINT;
import static com.fireflysemantics.math.exception.ExceptionKeys.EXPECTED;
import static com.fireflysemantics.math.exception.ExceptionKeys.LOWER_BRACKET;
import static com.fireflysemantics.math.exception.ExceptionKeys.UPPER_BRACKET;
import static com.fireflysemantics.math.exception.ExceptionTypes.NOT_POSITIVE;
import static com.fireflysemantics.math.exception.ExceptionTypes.NOT_STRICTLY_POSITIVE;
import static com.fireflysemantics.math.exception.ExceptionTypes.NO_DATA;
import static com.fireflysemantics.math.exception.ExceptionTypes.NULL_ARGUMENT;
import static com.fireflysemantics.math.exception.ExceptionTypes.NUMBER_TOO_SMALL;
import static com.fireflysemantics.math.exception.ExceptionTypes.OUT_OF_RANGE;

import com.fireflysemantics.math.exception.interfaces.ExceptionKey;

/**
 * Factory methods for constructing and throwing exceptions if the global
 * precondition checks do not pass.
 */
public class ExceptionFactory {

	/**
	 * Construct and throw a NUMBER_TOO_SMALL exception if {@code value} <
	 * {@code constraint}
	 * 
	 * @param key
	 *            The context key that labels the {@code value} parameter.
	 * @param value
	 *            Value to be checked against the {@code constraint}.
	 * @param constraint
	 *            Constraint that the {@code value} is checked against.
	 */
	public static void checkNumberTooSmall(ExceptionKey key, Number value, Number constraint) {
		if (value.doubleValue() < constraint.doubleValue()) {
			throw new MathException(NUMBER_TOO_SMALL).put(key, value).put(CONSTRAINT, constraint);
		}
	}

	/**
	 * Construct and throw a NULL_ARGUMENT exception if {@code arg} is null
	 * 
	 * @param key
	 *            The context key that labels the {@code arg} parameter.
	 * @param arg
	 *            The parameter to perform a null check against.
	 */
	public static void checkNullArgument(ExceptionKey key, Object arg) {
		if (arg == null) {
			throw new MathException(NULL_ARGUMENT).put(key, null);
		}
	}

	/**
	 * Construct and throw a NO_DATA exception if {@code arg.length} is zero.
	 * 
	 * @param key
	 *            The context key that labels the {@code arg} parameter.
	 * @param arrayLength
	 *            The parameter to perform a null check against.
	 */
	public static void checkNoData(ExceptionKey key, int arrayLength) {
		if (arrayLength == 0) {
			throw new MathException(NO_DATA).put(key, 0);
		}
	}

	/**
	 * Construct and throw a NOT_STRICTLY_POSITIVE exception if {@code value} is
	 * <= 0.
	 * 
	 * @param key
	 *            The context label for the {@code value} parameter.
	 * @param value
	 *            The parameter to perform a null check against.
	 */
	public static void checkNotStrictlyPositive(ExceptionKey key, Number value) {
		if (value.doubleValue() <= 0) {
			throw new MathException(NOT_STRICTLY_POSITIVE).put(key, value);
		}
	}

	/**
	 * Construct and throw a NOT_POSITIVE exception if {@code value} is < 0.
	 * 
	 * @param key
	 *            The context label for the {@code value} parameter.
	 * @param value
	 *            The parameter to perform a null check against.
	 */
	public static void checkNotPositive(ExceptionKey key, Number value) {
		if (value.doubleValue() < 0) {
			throw new MathException(NOT_POSITIVE).put(key, value);
		}
	}

	/**
	 * Construct and throw an OUT_OF_RANGE exception if {@code value} is <
	 * {@code lowerBracket} or > {@code upperBracket}.
	 * 
	 * @param key
	 *            The context label for the {@code value} parameter.
	 * @param value
	 *            The parameter to perform the range check against.
	 * @param lowerBracket
	 *            The lower bracket.
	 * @param upperBracket
	 *            The upper bracket.
	 */
	public static void checkOutOfRange(ExceptionKey key, Number value, Number lowerBracket,
			Number upperBracket) {
		if (value.doubleValue() < lowerBracket.doubleValue()
				|| value.doubleValue() > upperBracket.doubleValue()) {
			throw new MathException(OUT_OF_RANGE).put(key, value).put(LOWER_BRACKET, lowerBracket)
					.put(UPPER_BRACKET, upperBracket);
		}
	}

	/**
	 * Construct and throw an OUT_OF_RANGE exception if the zero based
	 * {@code index} is < {@code lowerBracket} or >= {@code upperBracket}.
	 * 
	 * @param index
	 *            The parameter to perform the range check against.
	 * @param lowerBracket
	 *            The lower bracket.
	 * @param upperBracket
	 *            The upper bracket.
	 */
	public static void checkIndexOutOfRange(Number index, Number lowerBracket, Number upperBracket) {
		if (index.intValue() < lowerBracket.intValue()
				|| index.intValue() >= upperBracket.intValue()) {
			throw new MathException(OUT_OF_RANGE).put(ExceptionKeys.INDEX, index)
					.put(LOWER_BRACKET, lowerBracket).put(UPPER_BRACKET, upperBracket);
		}
	}

	/**
	 * Construct and throw a DIMENSION_MISMATCH if {@code value} is !=
	 * dimension.
	 * 
	 * @param key
	 *            The context label for the {@code value} parameter.
	 * @param value
	 *            The parameter to perform match against the dimension.
	 * @param expected
	 *            The dimension target.
	 */
	public static void checkDimensionMismatch(ExceptionKey key, Number value, Number expected) {
		if (value.doubleValue() != expected.doubleValue()) {
			throw new MathException(ExceptionTypes.DIMENSION_MISMATCH).put(key, value).put(EXPECTED,
					expected);
		}
	}
}
