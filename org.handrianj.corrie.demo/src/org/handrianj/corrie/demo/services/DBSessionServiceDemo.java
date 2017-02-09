package org.handrianj.corrie.demo.services;

import org.handrianj.corrie.dblink.services.AbstractDBSessionService;
import org.handrianj.corrie.dblink.services.IDAOProvider;
import org.handrianj.corrie.demo.model.UserDemo;

public class DBSessionServiceDemo extends AbstractDBSessionService<UserDemo> {

	@Override
	public UserDemo login(String login, String password) {
		return new UserDemo(login, password);
	}

	@Override
	public boolean isPasswordCorrect(UserDemo user, String password) {
		return ((user.getUserName().compareTo("Test") == 0) && (password.compareTo("test") == 0));
	}

	@Override
	public void updatePassword(UserDemo user, String newPassword) {

	}

	@Override
	public void applicationChanged(UserDemo user, String applicationName) {

	}

	@Override
	protected IDAOProvider createNewService(UserDemo user) {
		return new ServiceDBProviderDemo();
	}

}
