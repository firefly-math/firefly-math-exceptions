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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Getter;

public class MathException extends RuntimeException {

	/** Expected context string */
	public static final String EXPECTED = "expected";

	/** Was context string */
	public static final String WAS = "was";

	/** @return The exception type */
	@Getter
	private ExceptionType type = null;

	/** @return The context */
	@Getter
	private Map<String, Object> context = null;

	/**
	 * Constructor
	 * 
	 * @param type
	 *            The exception type
	 * @param clazz
	 *            the class of the instance throwing the exception
	 * @param method
	 *            the method throwing the exception
	 */
	public MathException(ExceptionType type) {
		this.type = type;
		this.context = new LinkedHashMap<String, Object>();
	}

	@Override
	public String toString() {
		String parameters = context.entrySet().stream().map(e -> e.getKey()
				+ "="
				+ e.getValue()).collect(Collectors.joining(", "));

		return "Firefly math exception type "
				+ this.type
				+ ".  Context ["
				+ parameters
				+ "]";
	}
}