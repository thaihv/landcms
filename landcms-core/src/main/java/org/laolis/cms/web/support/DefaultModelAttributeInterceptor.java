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

import org.laolis.cms.autoconfigure.WallRideServletConfiguration;
import org.laolis.cms.domain.Blog;
import org.laolis.cms.domain.BlogLanguage;
import org.laolis.cms.service.BlogService;
import org.laolis.cms.support.AuthorizedUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DefaultModelAttributeInterceptor extends HandlerInterceptorAdapter {

	private BlogService blogService;

	private static Logger logger = LoggerFactory.getLogger(DefaultModelAttributeInterceptor.class);

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	@Override
	public void postHandle(
			HttpServletRequest request,
			HttpServletResponse response,
			Object handler,
			ModelAndView mv)
			throws Exception {
		if (mv == null) return;
		if (mv.getView() instanceof RedirectView) return;
		if (mv.getViewName().startsWith("redirect:")) return;

		Blog blog = blogService.getBlogById(Blog.DEFAULT_ID);
		mv.addObject("BLOG", blog);

		List<String> languages = new ArrayList<>();
		if (blog != null) {
			for (BlogLanguage blogLanguage : blog.getLanguages()) {
				languages.add(blogLanguage.getLanguage());
			}
		}

		String currentLanguage = LocaleContextHolder.getLocale().getLanguage();

		mv.addObject("LANGUAGES", languages.toArray(new String[languages.size()]));
		mv.addObject("LANGUAGE_LINKS", buildLanguageLinks(currentLanguage, languages, request));

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		AuthorizedUser authorizedUser = null;
		if (authentication != null && authentication.getPrincipal() instanceof AuthorizedUser) {
			authorizedUser = (AuthorizedUser) authentication.getPrincipal();
		}
		mv.addObject("USER", authorizedUser);

		mv.addObject("WEBSITE_TITLE", blog != null ? blog.getTitle(currentLanguage) : null);
		mv.addObject("WEBSITE_LINK", buildGuestLink());
		mv.addObject("WEBSITE_PATH", buildGuestPath(currentLanguage, languages));

		mv.addObject("ADMIN_LINK", buildAdminLink());
		mv.addObject("ADMIN_PATH", buildAdminPath(currentLanguage));
	}

	private String buildGuestLink() {
		UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
		return builder.buildAndExpand().toUriString();
	}

	private String buildGuestPath(String currentLanguage, List<String> languages) {
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
		if (languages.size() > 1) {
			builder.path("/{language}");
		}
		return builder.buildAndExpand(currentLanguage).toUriString();
	}

	private String buildAdminLink() {
		UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentContextPath();
		builder.path("/_admin");
		return builder.buildAndExpand().toUriString();
	}

	private String buildAdminPath(String currentLanguage) {
//		String contextPath = request.getContextPath();
		UriComponentsBuilder builder = UriComponentsBuilder.fromPath(WallRideServletConfiguration.ADMIN_SERVLET_PATH);
		builder.path("/{language}");
		return builder.buildAndExpand(currentLanguage).toUriString();
	}

	private Map<String, String> buildLanguageLinks(String currentLanguage, List<String> languages, HttpServletRequest request) {
		UrlPathHelper pathHelper = new UrlPathHelper();
		Map<String, String> languageLinks = new LinkedHashMap<>();
		String path = pathHelper.getPathWithinServletMapping(request);
		if (path.startsWith("/" + currentLanguage + "/")) {
			path = path.substring(currentLanguage.length() + 1);
		}
		UriComponentsBuilder uriComponentsBuilder = ServletUriComponentsBuilder
				.fromCurrentServletMapping()
				.path("/{language}")
				.path(path)
				.query(pathHelper.getOriginatingQueryString(request));
		if (languages != null) {
			for (String language : languages) {
				languageLinks.put(language, uriComponentsBuilder.buildAndExpand(language).toUriString());
			}
		}
		return languageLinks;
	}
}
