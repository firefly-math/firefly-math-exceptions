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

package com.fireflysemantics.math.exceptions;

public enum ExceptionTypes implements ExceptionType {

	DIMENSION_MISMATCH_EXCEPTION("DIMENSION_MISMATCH_EXCEPTION"),
	CONVERGENCE_EXCEPTION("CONVERGENCE_EXCEPTION"),
	INSUFFICIENT_DATA_EXCEPTION("INSUFFICIENT_DATA_EXCEPTION"),
	MATH_ARITHMETIC_EXCEPTION("MATH_ARITHMETIC_EXCEPTION"),
	MATH_ILLEGAL_ARGUMENT_EXCEPTION("MATH_ILLEGAL_ARGUMENT_EXCEPTION"),
	MATH_ILLEGAL_NUMBER_EXCEPTION("MATH_ILLEGAL_NUMBER_EXCEPTION"),
	MATH_ILLEGAL_STATE_EXCEPTION("MATH_ILLEGAL_STATE_EXCEPTION"),
	MATH_INTERNAL_ERROR("MATH_INTERNAL_ERROR"),
	MATH_PARSE_EXCEPTION("MATH_PARSE_EXCEPTION"),
	MATH_RUNTIME_EXCEPTION("MATH_RUNTIME_EXCEPTION"),
	MATH_UNSUPPORTED_OPERATION_EXCEPTION("MATH_UNSUPPORTED_OPERATION_EXCEPTION"),
	MAX_COUNT_EXCEEDED_EXCEPTION("MAX_COUNT_EXCEEDED_EXCEPTION"),
	MULTI_DIMENSIONAL_MISMATCH_EXCEPTION("MULTI_DIMENSIONAL_MISMATCH_EXCEPTION"),
	NO_BRACKETING_EXCEPTION("NO_BRACKETING_EXCEPTION"),
	NO_DATA_EXCEPTION("NO_DATA_EXCEPTION"),
	NON_MONOTONIC_SEQUENCE_EXCEPTION("NON_MONOTONIC_SEQUENCE_EXCEPTION"),
	NOT_A_NUMBER_EXCEPTION("NOT_A_NUMBER_EXCEPTION"),
	NOT_FINITE_NUMBER_EXCEPTION("NOT_FINITE_NUMBER_EXCEPTION"),
	NOT_POSITIVE_EXCEPTION("NOT_POSITIVE_EXCEPTION"),
	NOT_STRICTLY_POSITIVE_EXCEPTION("NOT_STRICTLY_POSITIVE_EXCEPTION"),
	NULL_ARGUMENT_EXCEPTION("NULL_ARGUMENT_EXCEPTION"),
	NUMBER_TOO_LARGE_EXCEPTION("NUMBER_TOO_LARGE_EXCEPTION"),
	NUMBER_TOO_SMALL_EXCEPTION("NUMBER_TOO_SMALL_EXCEPTION"),
	OUT_OF_RANGE_EXCEPTION("OUT_OF_RANGE_EXCEPTION"),
	TOO_MANY_EVALUATIONS_EXCEPTIONS("TOO_MANY_EVALUATIONS_EXCEPTIONS"),
	TOO_MANY_ITERATIONS_EXCEPTION("TOO_MANY_ITERATIONS_EXCEPTION"),
	ZERO_EXCEPTION("ZERO_EXCEPTION");

	/** The exception code */
	private String type = null;

	/** Constructor */
	private ExceptionTypes(String t) {
		this.type = t;
	}

	public String getType() {
		return this.type;
	}
}
