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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.fireflysemantics.math.exception.interfaces.ExceptionType;

import lombok.Getter;

/** Exception class for all Firefly Math modules */
public class MathException extends RuntimeException {

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
	 */
	public MathException(ExceptionType type) {
		super(type.toString());
		this.type = type;
		this.context = new LinkedHashMap<String, Object>();
	}

	/**
	 * Fluid put for adding exception parameters to the context.
	 * 
	 * @return this
	 */
	public MathException put(String key, Object value) {
		this.context.put(key, value);
		return this;
	}

	/**
	 * Retrieve an exception context value
	 * 
	 * @return Object instance holding the value
	 */
	public Object get(String key) {
		return this.context.get(key);
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
