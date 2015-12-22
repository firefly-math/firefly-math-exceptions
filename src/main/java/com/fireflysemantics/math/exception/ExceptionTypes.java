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

import com.fireflysemantics.math.exception.interfaces.ExceptionType;

public enum ExceptionTypes implements ExceptionType {

	/**
	 * MATH ARITHMETIC EXCEPTIONS
	 */
	MAE,
	MAE__INTEGER_OVERFLOW,
	MAE__LONG_OVERFLOW,
	MAE__OVERFLOW_IN_ADDITION,
	MAE__OVERFLOW_IN_SUBTRACTION,
	MAE__GCD_OVERFLOW_32_BITS,
	MAE__GCD_OVERFLOW_64_BITS,
	MAE__LCM_OVERFLOW_32_BITS,
	MAE__LCM_OVERFLOW_64_BITS,
	MAE__DIVISION_BY_ZERO,

	/**
	 * MATH ILLEGAL STATE EXCEPTIONS
	 */
	MISE,
	MISE__FIRST_ROWS_NOT_INITIALIZED_YET,
	MISE__FIRST_COLUMNS_NOT_INITIALIZED_YET,

	/**
	 * MATH NO DATA EXCEPTIONS
	 */
	NO_DATA,
	NO_DATA__AT_LEAST_ONE_ROW,
	NO_DATA__AT_LEAST_ONE_COL,

	NULL_ARGUMENT,
	DIMENSION_MISMATCH,
	NOT_STRICTLY_POSITIVE,
	NOT_POSITIVE,
	MATRIX_DIMENSION_MISMATCH,
	NON_SQUARE_MATRIX,
	NUMBER_TOO_SMALL,
	OUT_OF_RANGE,

	// NOT YET USED
	CONVERGENCE_EXCEPTION,
	INSUFFICIENT_DATA_EXCEPTION,
	MATH_ILLEGAL_ARGUMENT_EXCEPTION,
	MATH_ILLEGAL_NUMBER,
	MATH_INTERNAL_ERROR,
	MATH_PARSE,
	MATH_UNSUPPORTED_OPERATION,
	MAX_COUNT_EXCEEDED,
	MULTI_DIMENSIONAL_MISMATCH,
	NO_BRACKETING_EXCEPTION,
	NON_MONOTONIC_SEQUENCE,
	NOT_A_NUMBER,
	NOT_FINITE_NUMBER,
	NUMBER_TOO_LARGE,
	TOO_MANY_EVALUATIONS,
	TOO_MANY_ITERATIONS,
	ZERO;
}
