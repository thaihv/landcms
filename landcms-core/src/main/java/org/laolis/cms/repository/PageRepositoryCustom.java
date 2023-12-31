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

package org.laolis.cms.repository;

import org.laolis.cms.domain.Page;
import org.laolis.cms.model.PageSearchRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PageRepositoryCustom {

	org.springframework.data.domain.Page<Page> search(PageSearchRequest request);
	org.springframework.data.domain.Page<Page> search(PageSearchRequest request, Pageable pageable);
	List<Long> searchForId(PageSearchRequest request);
}
