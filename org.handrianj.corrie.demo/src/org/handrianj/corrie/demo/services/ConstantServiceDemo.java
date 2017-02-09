package org.handrianj.corrie.demo.services;

import java.util.Collection;

import org.handrianj.corrie.dblink.services.IConstantService;
import org.handrianj.corrie.demo.model.Constants;

public class ConstantServiceDemo implements IConstantService<Object, Constants> {

	public ConstantServiceDemo() {
	}

	@Override
	public void init(Object connector) {

	}

	@Override
	public String getStringforAttribute(Constants attribute, int languageId, int index) {
		return null;
	}

	@Override
	public Collection<String> getAllValuesforAttribute(Constants attribute, int languageId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKeyforAttributeIndex(Constants attribute, int languageId, int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Integer> getAllKeysForAttribute(Constants attribute, int languageId) {
		// TODO Auto-generated method stub
		return null;
	}

}
