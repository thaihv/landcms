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

package org.laolis.cms.web.support;

import org.laolis.cms.domain.BlogLanguage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.support.RequestDataValueProcessor;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class BlogLanguageDataValueProcessor implements RequestDataValueProcessor {

	private static Logger logger = LoggerFactory.getLogger(BlogLanguageDataValueProcessor.class);

	@Override
	public String processAction(HttpServletRequest request, String action, String httpMethod) {
		return processUrl(request, action);
	}

	@Override
	public String processFormFieldValue(HttpServletRequest request, String name, String value, String type) {
		return value;
	}

	@Override
	public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
		return null;
	}

	@Override
	public String processUrl(HttpServletRequest request, String url) {
		UrlPathHelper urlPathHelper = new UrlPathHelper();
		String contextPath = urlPathHelper.getContextPath(request);

		if (!url.startsWith(contextPath + "/")) {
			return url;
		}

		BlogLanguage blogLanguage = (BlogLanguage) request.getAttribute(BlogLanguageMethodArgumentResolver.BLOG_LANGUAGE_ATTRIBUTE);
		if (blogLanguage == null || blogLanguage.getBlog().getLanguages().size() <= 1) {
			return url;
		}

		String path = url.substring(contextPath.length());
		// The temporary fix for user login with multi-language settings 
		if (path.equals("/login") || path.equals("/logout"))
			return path;
		
		String processedUrl = contextPath + "/" + blogLanguage.getLanguage() + path;
		logger.debug(url + " => " + processedUrl);
		return processedUrl;
	}
}
