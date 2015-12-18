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
package com.fireflysemantics.math.exceptions.factory;

import com.fireflysemantics.math.exceptions.MathException;
import com.fireflysemantics.math.exceptions.keys.ExceptionKeys;
import com.fireflysemantics.math.exceptions.types.ExceptionTypes;

/** Factory methods for constructing and throwing exceptions */
public class ExceptionFactory {

	/** Construct and throw a NUMBER_TOO_SMALL_EXCEPTION */
	public static void throwNumberToSmallException(Object value, Object constraint) {
		throw new MathException(ExceptionTypes.NUMBER_TOO_SMALL_EXCEPTION)
				.put(ExceptionKeys.CONSTRAINT, constraint).put(ExceptionKeys.VALUE, value);
	}

	/** Construct and throw a NUMBER_TOO_SMALL_EXCEPTION */
	public static void throwNullArgumentException() {
		throw new MathException(ExceptionTypes.NULL_ARGUMENT_EXCEPTION);
	}
}
