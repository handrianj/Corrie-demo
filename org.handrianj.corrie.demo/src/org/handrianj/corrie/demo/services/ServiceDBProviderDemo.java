package org.handrianj.corrie.demo.services;

import org.handrianj.corrie.dblink.model.IDAObject;
import org.handrianj.corrie.dblink.services.IDAOProvider;

public class ServiceDBProviderDemo implements IDAOProvider {

	@Override
	public IDAObject getDBAccessForClass(Class clazz) {

		return new DBObjectAccessorDemo();
	}

	@Override
	public void closeSession() {

	}

}
