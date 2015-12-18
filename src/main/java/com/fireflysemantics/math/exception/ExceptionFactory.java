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

/** Factory methods for constructing and throwing exceptions */
public class ExceptionFactory {

	/**
	 * Construct and throw a NUMBER_TOO_SMALL_EXCEPTION if {@code value} <
	 * {@code constraint}
	 * 
	 * @param value
	 *            Value to be checked against the {@code constraint}
	 * @param key
	 *            The context key that labels the {@code value} parameter.
	 * @param constraint
	 *            Constraint that the {@code value} is checked against
	 */
	public static void throwNumberToSmallException(Number value, Number constraint, String key) {
		if (value.doubleValue() < constraint.doubleValue()) {
			throw new MathException(ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION)
					.put(ExceptionKeys.CONSTRAINT, constraint).put(ExceptionKeys.VALUE, value)
					.put(key, value);
		}
	}

	/**
	 * Construct and throw a NULL_ARGUMENT_EXCEPTION if {@code arg} is null
	 * 
	 * @param arg
	 *            The parameter to perform a null check against.
	 * @param key
	 *            The context key that labels the {@code arg} parameter.
	 */
	public static void throwNullArgumentException(Object arg, String key) {
		if (arg == null) {
			throw new MathException(ExceptionTypes.NULL_ARGUMENT_EXCEPTION).put(key, null);
		}
	}

	/**
	 * Construct and throw a NOT_STRICTLY_POSITIVE_EXCEPTION if {@code value} is
	 * <= 0.
	 * 
	 * @param value
	 *            The parameter to perform a null check against.
	 * @param key
	 *            The context that labels the {@code value} parameter.
	 */
	public static void throwNotStrictlyPositiveException(Number value, String key) {
		if (value.doubleValue() <= 0) {
			throw new MathException(ExceptionTypes.NOT_STRICTLY_POSITIVE_EXCEPTION).put(key, value);
		}
	}
}
