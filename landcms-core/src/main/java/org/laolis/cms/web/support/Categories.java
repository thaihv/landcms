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

import org.laolis.cms.domain.Category;
import org.laolis.cms.model.TreeNode;
import org.laolis.cms.support.CategoryUtils;
import org.thymeleaf.context.IExpressionContext;

import java.util.List;

public class Categories {

	private IExpressionContext context;

	private CategoryUtils CategoryUtils;

	public Categories(IExpressionContext context, CategoryUtils CategoryUtils) {
		this.context = context;
		this.CategoryUtils = CategoryUtils;
	}

	public List<Category> getAllCategories() {
		return CategoryUtils.getAllCategories();
	}

	public List<Category> getAllCategories(boolean includeNoPosts) {
		return CategoryUtils.getAllCategories(includeNoPosts);
	}

	public List<TreeNode<Category>> getNodes() {
		return CategoryUtils.getNodes();
	}

	public List<TreeNode<Category>> getNodes(boolean includeNoPosts) {
		return CategoryUtils.getNodes(includeNoPosts);
	}
}