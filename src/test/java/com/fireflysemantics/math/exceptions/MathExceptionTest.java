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

import com.fireflysemantics.math.exceptions.factory.ExceptionFactory;
import com.fireflysemantics.math.exceptions.keys.ExceptionKeys;
import com.fireflysemantics.math.exceptions.types.ExceptionTypes;

public class MathExceptionTest {

	@Test(expected = MathException.class)
	public void verifyThrows() {
		throw new MathException(ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION);
	}

	@Test
	public void verifyCode() {
		try {
			throw new MathException(ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION);
		} catch (MathException e) {
			assertEquals(e.getType(), ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION);
		}
	}

	@Test
	public void verifyContext() {
		try {
			throw new MathException(ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION)
					.put(ExceptionKeys.CONSTRAINT, 2).put(ExceptionKeys.VALUE, 1);
		} catch (MathException e) {
			assertEquals(e.getContext().get(ExceptionKeys.CONSTRAINT), 2);
			assertEquals(e.getContext().get(ExceptionKeys.VALUE), 1);
		}
	}

	@Test
	public void verifyToString() {
		try {
			throw new MathException(ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION)
					.put(ExceptionKeys.CONSTRAINT, 2).put(ExceptionKeys.VALUE, 1);
		} catch (MathException e) {
			assertTrue(e.toString().contains(ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION.toString()));
			assertTrue(e.toString().contains("1"));
			assertTrue(e.toString().contains("2"));
			assertTrue(e.toString().contains(ExceptionKeys.CONSTRAINT));
			assertTrue(e.toString().contains(ExceptionKeys.VALUE));
		}
	}

	@Test
	public void verifyFactory() {
		try {
			ExceptionFactory.throwNumberToSmallException(2, 1);
		} catch (MathException e) {
			assertTrue(e.getType() == ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION);
			assertEquals(e.get(ExceptionKeys.CONSTRAINT), new Integer(1));
			assertEquals(e.get(ExceptionKeys.VALUE), new Integer(2));
		}
	}
}
