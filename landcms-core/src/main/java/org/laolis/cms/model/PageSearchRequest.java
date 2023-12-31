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

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.laolis.cms.domain.BlogLanguage;
import org.laolis.cms.domain.Post;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class PageSearchRequest implements Serializable {

	private String keyword;
	private Collection<Long> tagIds;
	private Collection<String> tagNames;
	private Collection<Long> categoryIds;
	private Collection<String> categoryCodes;
	private MultiValueMap<String, Object> customFields;
	private Long authorId;
	private Post.Status status;
	private String language;

	public PageSearchRequest() {
		this.language = LocaleContextHolder.getLocale().getLanguage();
	}

	public PageSearchRequest(BlogLanguage blogLanguage) {
		this.language = blogLanguage.getLanguage();
	}

	public PageSearchRequest(String language) {
		this.language = language;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public PageSearchRequest withKeyword(String keyword) {
		this.keyword = keyword;
		return this;
	}

	public Collection<Long> getTagIds() {
		return tagIds;
	}

	public void setTagIds(Collection<Long> tagIds) {
		this.tagIds = tagIds;
	}

	public PageSearchRequest withTagIds(Long... tags) {
		if (getTagIds() == null) {
			setTagIds(new ArrayList<Long>(tags.length));
		}
		for (Long value : tags) {
			getTagIds().add(value);
		}
		return this;
	}

	public PageSearchRequest withTagIds(Collection<Long> tags) {
		if (tags == null) {
			this.tagIds = null;
		} else {
			this.tagIds = new ArrayList<>(tags);
		}
		return this;
	}

	public Collection<String> getTagNames() {
		return tagNames;
	}

	public void setTagNames(Collection<String> tagNames) {
		this.tagNames = tagNames;
	}

	public PageSearchRequest withTagNames(String... tags) {
		if (getTagNames() == null) {
			setTagNames(new ArrayList<String>(tags.length));
		}
		for (String value : tags) {
			getTagNames().add(value);
		}
		return this;
	}

	public PageSearchRequest withTagNames(Collection<String> tags) {
		if (tags == null) {
			this.tagNames = null;
		} else {
			this.tagNames = new ArrayList<>(tags);
		}
		return this;
	}


	public Collection<Long> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Collection<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public PageSearchRequest withCategoryIds(Long... categoryIds) {
		if (getCategoryIds() == null) {
			setCategoryIds(new ArrayList<>(categoryIds.length));
		}
		for (Long value : categoryIds) {
			getCategoryIds().add(value);
		}
		return this;
	}

	public PageSearchRequest withCategoryIds(Collection<Long> categoryIds) {
		if (categoryIds == null) {
			this.categoryIds = null;
		} else {
			this.categoryIds = new ArrayList<>(categoryIds);
		}
		return this;
	}

	public Collection<String> getCategoryCodes() {
		return categoryCodes;
	}


	public void setCategoryCodes(Collection<String> categoryCodes) {
		this.categoryCodes = categoryCodes;
	}

	public PageSearchRequest withCategoryCodes(String... categoryCodes) {
		if (getCategoryCodes() == null) {
			setCategoryCodes(new ArrayList<>(categoryCodes.length));
		}
		for (String value : categoryCodes) {
			getCategoryCodes().add(value);
		}
		return this;
	}

	public PageSearchRequest withCategoryCodes(Collection<String> categoryCodes) {
		if (categoryCodes == null) {
			this.categoryCodes = null;
		} else {
			this.categoryCodes = categoryCodes;
		}
		return this;
	}
	public MultiValueMap<String, Object> getCustomFields() {
		return customFields;
	}

	public void setCustomFields(MultiValueMap<String, Object> customFields) {
		this.customFields = customFields;
	}

	public PageSearchRequest withCustomFields(MultiValueMap<String, Object> customFields) {
		this.customFields = customFields;
		return this;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public PageSearchRequest withAuthorId(Long authorId) {
		this.authorId = authorId;
		return this;
	}

	public Post.Status getStatus() {
		return status;
	}

	public void setStatus(Post.Status status) {
		this.status = status;
	}

	public PageSearchRequest withStatus(Post.Status status) {
		this.status = status;
		return this;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public PageSearchRequest withLanguage(String language) {
		this.language = language;
		return this;
	}

	public boolean isEmpty() {
		if (StringUtils.hasText(getKeyword())) {
			return false;
		}
		if (!CollectionUtils.isEmpty(getTagIds())) {
			return false;
		}
		if (!CollectionUtils.isEmpty(getTagNames())) {
			return false;
		}
		if (!CollectionUtils.isEmpty(getCustomFields())) {
			return false;
		}
		if (getAuthorId() != null) {
			return false;
		}
		if (getStatus() != null) {
			return false;
		}
		if (StringUtils.hasText(getLanguage())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
