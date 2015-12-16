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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MathExceptionTest {

	@Test(expected = MathException.class)
	public void verifyThrows() {
		throw new MathException(ExceptionTypes.DIMENSION_MISMATCH_EXCEPTION);
	}

	@Test
	public void verifyCode() {
		try {
			throw new MathException(ExceptionTypes.DIMENSION_MISMATCH_EXCEPTION);
		} catch (MathException e) {
			assertEquals(e.getType(), ExceptionTypes.DIMENSION_MISMATCH_EXCEPTION);
		}
	}

	@Test
	public void verifyContext() {
		try {
			MathException e = new MathException(ExceptionTypes.DIMENSION_MISMATCH_EXCEPTION);
			e.getContext().put(ExceptionKeys.EXPECTED, 2);
			e.getContext().put(ExceptionKeys.WAS, 3);
			throw e;
		} catch (MathException e) {
			assertEquals(e.getContext().get(ExceptionKeys.EXPECTED), 2);
			assertEquals(e.getContext().get(ExceptionKeys.WAS), 3);
		}
	}

	@Test
	public void verifyToString() {
		try {
			MathException e = new MathException(ExceptionTypes.DIMENSION_MISMATCH_EXCEPTION);
			e.getContext().put(ExceptionKeys.EXPECTED, 2);
			e.getContext().put(ExceptionKeys.WAS, 3);
			throw e;
		} catch (MathException e) {
			assertTrue(e.toString().contains("2"));
			assertTrue(e.toString().contains("3"));
			assertTrue(e.toString().contains(ExceptionKeys.EXPECTED));
			assertTrue(e.toString().contains(ExceptionKeys.WAS));
		}
	}
}
