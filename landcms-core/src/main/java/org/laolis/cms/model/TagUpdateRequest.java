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

package org.laolis.cms.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TagUpdateRequest implements Serializable {

	private Long id;
	private String name;
	private String language;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public static class Builder  {

		private Long id;
		private String name;
		private String language;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder language(String language) {
			this.language = language;
			return this;
		}

		public TagUpdateRequest build() {
			TagUpdateRequest request = new TagUpdateRequest();
			request.id = id;
			request.name = name;
			request.language = language;
			return request;
		}
	}
}
