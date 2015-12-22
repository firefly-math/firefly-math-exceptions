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

import static com.fireflysemantics.math.exception.ExceptionKeys.CONSTRAINT;
import static com.fireflysemantics.math.exception.ExceptionKeys.VALUE;
import static com.fireflysemantics.math.exception.ExceptionTypes.NUMBER_TOO_SMALL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.fireflysemantics.math.exception.ExceptionFactory;
import com.fireflysemantics.math.exception.MathException;

public class MathExceptionTest {

	@Test(expected = MathException.class)
	public void verifyThrows() {
		throw new MathException(NUMBER_TOO_SMALL);
	}

	@Test
	public void verifyCode() {
		try {
			throw new MathException(NUMBER_TOO_SMALL);
		} catch (MathException e) {
			assertEquals(e.getType(), NUMBER_TOO_SMALL);
		}
	}

	@Test
	public void verifyContext() {
		try {
			throw new MathException(NUMBER_TOO_SMALL).put(CONSTRAINT, 2).put(VALUE, 1);
		} catch (MathException e) {
			assertEquals(e.get(CONSTRAINT), 2);
			assertEquals(e.get(VALUE), 1);
		}
	}

	@Test
	public void verifyToString() {
		try {
			throw new MathException(NUMBER_TOO_SMALL).put(CONSTRAINT, 2).put(VALUE, 1);
		} catch (MathException e) {
			assertTrue(e.toString().contains(NUMBER_TOO_SMALL.toString()));
			assertTrue(e.toString().contains("1"));
			assertTrue(e.toString().contains("2"));
			assertTrue(e.toString().contains(CONSTRAINT));
			assertTrue(e.toString().contains(VALUE));
		}
	}

	@Test
	public void verifyFactory() {
		try {
			ExceptionFactory.checkNumberToSmallException(1, 2, "foo");
			fail("Should move on to catch");
		} catch (MathException e) {
			assertTrue(e.getType() == NUMBER_TOO_SMALL);
			assertEquals(e.get(CONSTRAINT), new Integer(2));
			assertEquals(e.get(VALUE), new Integer(1));
			assertEquals(e.get("foo"), new Integer(1));
		}
	}
}
