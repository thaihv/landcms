package org.laolis.cms.repository;

import org.laolis.cms.domain.CustomField;
import org.laolis.cms.model.CustomFieldSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomFieldRepositoryCustom {

	void lock(long id);
	Page<CustomField> search(CustomFieldSearchRequest request);
	Page<CustomField> search(CustomFieldSearchRequest request, Pageable pageable);
	List<Long> searchForId(CustomFieldSearchRequest request);
}
