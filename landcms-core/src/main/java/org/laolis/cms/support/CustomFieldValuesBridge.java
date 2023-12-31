package org.laolis.cms.support;

import org.apache.lucene.document.Document;
import org.hibernate.search.bridge.FieldBridge;
import org.hibernate.search.bridge.LuceneOptions;
import org.laolis.cms.domain.CustomFieldValue;

import java.util.Collection;

public class CustomFieldValuesBridge implements FieldBridge {

	@Override
	public void set(String name, Object value, Document document, LuceneOptions luceneOptions) {
		Collection<CustomFieldValue> customFieldValues = (Collection<CustomFieldValue>) value;
		if (customFieldValues != null) {
			for (CustomFieldValue cfv : customFieldValues) {
				if (cfv.getValue() != null) {
					luceneOptions.addFieldToDocument(name + "." + cfv.getCustomField().getCode(), cfv.getValue().toString(), document);
				}
			}
		}
	}
}
