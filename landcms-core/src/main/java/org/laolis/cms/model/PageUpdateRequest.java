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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.laolis.cms.web.controller.admin.article.CustomFieldValueEditForm;

@SuppressWarnings("serial")
public class PageUpdateRequest implements Serializable {
	
	private Long id;
	private String code;
	private String coverId;
	private String title;
	private String body;
	private Long authorId;
	private LocalDateTime date;
	private Long parentId;
	private Set<Long> categoryIds = new HashSet<>();
	private String tags;
	private Set<Long> relatedPostIds = new HashSet<>();
	private String seoTitle;
	private String seoDescription;
	private String seoKeywords;
	private List<CustomFieldValueEditForm> customFieldValues = new ArrayList<>();
//	private Post.Status status;
	private String language;

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getCoverId() {
		return coverId;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public Long getParentId() {
		return parentId;
	}

	public Set<Long> getCategoryIds() {
		return categoryIds;
	}

	public String getTags() {
		return tags;
	}

	public Set<Long> getRelatedPostIds() {
		return relatedPostIds;
	}

	public String getSeoTitle() {
		return seoTitle;
	}

	public String getSeoDescription() {
		return seoDescription;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public List<CustomFieldValueEditForm> getCustomFieldValues() {
		return customFieldValues;
	}

	//	public Post.Status getStatus() {
//		return status;
//	}

	public String getLanguage() {
		return language;
	}

	public static class Builder  {

		private Long id;
		private String code;
		private String coverId;
		private String title;
		private String body;
		private Long authorId;
		private LocalDateTime date;
		private Long parentId;
		private Set<Long> categoryIds = new HashSet<>();
		private String tags;
		private Set<Long> relatedPostIds = new HashSet<>();
		private String seoTitle;
		private String seoDescription;
		private String seoKeywords;
		private List<CustomFieldValueEditForm> customFieldValues = new ArrayList<>();
		private String language;

		public Builder() {
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder code(String code) {
			this.code = code;
			return this;
		}

		public Builder coverId(String coverId) {
			this.coverId = coverId;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder body(String body) {
			this.body = body;
			return this;
		}

		public Builder authorId(Long authorId) {
			this.authorId = authorId;
			return this;
		}

		public Builder date(LocalDateTime date) {
			this.date = date;
			return this;
		}

		public Builder parentId(Long parentId) {
			this.parentId = parentId;
			return this;
		}

		public Builder categoryIds(Set<Long> categoryIds) {
			this.categoryIds = categoryIds;
			return this;
		}

		public Builder tags(String tags) {
			this.tags = tags;
			return this;
		}

		public Builder relatedPostIds(Set<Long> relatedPostIds) {
			this.relatedPostIds = relatedPostIds;
			return this;
		}

		public Builder seoTitle(String seoTitle) {
			this.seoTitle = seoTitle;
			return this;
		}

		public Builder seoDescription(String seoDescription) {
			this.seoDescription = seoDescription;
			return this;
		}

		public Builder seoKeywords(String seoKeywords) {
			this.seoKeywords = seoKeywords;
			return this;
		}

		public Builder customFieldValues(List<CustomFieldValueEditForm> customFieldValues) {
			this.customFieldValues = customFieldValues;
			return this;
		}

		public Builder language(String language) {
			this.language = language;
			return this;
		}

		public PageUpdateRequest build() {
			PageUpdateRequest request = new PageUpdateRequest();
			request.id = id;
			request.code = code;
			request.coverId = coverId;
			request.title = title;
			request.body = body;
			request.authorId = authorId;
			request.date = date;
			request.parentId = parentId;
			request.categoryIds = categoryIds;
			request.tags = tags;
			request.relatedPostIds = relatedPostIds;
			request.seoTitle = seoTitle;
			request.seoDescription = seoDescription;
			request.seoKeywords = seoKeywords;
			request.customFieldValues = customFieldValues;
//			request.status = status;
			request.language = language;
			return request;
		}
	}
}
