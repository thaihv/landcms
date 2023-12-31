/*
 * Copyright 2014 Tagbangers, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.laolis.cms.exception;

public class DuplicateNameException extends ServiceException {

	private String name;

	public DuplicateNameException(String name) {
		super();
		this.name = name;
	}

	public DuplicateNameException(String name, Throwable cause) {
		super(cause);
		this.name = name;
	}

	public DuplicateNameException(String name, String message) {
		super(message);
		this.name = name;
	}

	public DuplicateNameException(String name, String message, Throwable cause) {
		super(message, cause);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
