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

package org.laolis.cms.web.controller.admin.user;

import org.laolis.cms.domain.User;
import org.laolis.cms.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.validation.Valid;

@Controller
@RequestMapping(value="/{language}/users/delete", method= RequestMethod.POST)
public class UserDeleteController {
	
	private static Logger logger = LoggerFactory.getLogger(UserDeleteController.class);
	
	@Inject
	private UserService userService;

	@ModelAttribute("query")
	public String query(@RequestParam(required = false) String query) {
		return query;
	}

	@RequestMapping
	public String delete(
			@Valid @ModelAttribute("form") UserDeleteForm form,
			BindingResult errors,
			String query,
			RedirectAttributes redirectAttributes) {
		if (!form.isConfirmed()) {
			errors.rejectValue("confirmed", "Confirmed");
		}
		if (errors.hasErrors()) {
			logger.debug("Errors: {}", errors);
			return "user/describe";
		}

		User deletedUser;
		try {
			deletedUser = userService.deleteUser(form.buildUserDeleteRequest(), errors);
		}
		catch (BindException e) {
			if (errors.hasErrors()) {
				logger.debug("Errors: {}", errors);
				return "user/describe";
			}
			throw new RuntimeException(e);
		}

		redirectAttributes.addFlashAttribute("deletedUser", deletedUser);
		redirectAttributes.addAttribute("query", query);
		return "redirect:/_admin/{language}/users/index";
	}
}
