package org.laolis.cms.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.laolis.cms.domain.CustomField;

public class CustomFieldUpdateRequest implements Serializable {

	private long id;
	private String name;
	private String code;
	private CustomField.FieldType type = CustomField.FieldType.UNDEFINED;
	private String description;
	private List<String> options = new ArrayList<>();
	private String language;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public CustomField.FieldType getType() {
		return type;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getOptions() {
		return options;
	}

	public String getLanguage() {
		return language;
	}

	public static class Builder {

		private long id;
		private String name;
		private String code;
		private CustomField.FieldType type = CustomField.FieldType.UNDEFINED;
		private String description;
		private List<String> options = new ArrayList<>();
		private String language;

		public Builder() {
		}

		public Builder id(long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder code(String code) {
			this.code = code;
			return this;
		}

		public Builder type(CustomField.FieldType type) {
			this.type = type;
			return this;
		}

		public Builder description(String description) {
			this.description = description;
			return this;
		}

		public Builder options(List<String> options) {
			this.options = options;
			return this;
		}

		public Builder language(String language) {
			this.language = language;
			return this;
		}

		public CustomFieldUpdateRequest build() {
			CustomFieldUpdateRequest request = new CustomFieldUpdateRequest();
			request.id = id;
			request.name = name;
			request.code = code;
			request.type = type;
			request.description = description;
			request.options = options;
			request.language = language;
			return request;
		}
	}
}
