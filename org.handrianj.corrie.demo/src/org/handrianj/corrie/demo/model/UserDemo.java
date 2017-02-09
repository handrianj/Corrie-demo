package org.handrianj.corrie.demo.model;

import java.util.HashSet;
import java.util.Set;

import org.handrianj.corrie.datamodel.entities.IUser;

public class UserDemo implements IUser {

	private String userName;

	private String userPassword;

	public UserDemo(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public String getUserId() {
		return "";
	}

	@Override
	public String getPassWord() {
		return userPassword;
	}

	@Override
	public boolean isActive() {
		return true;
	}

	@Override
	public Set<Integer> getRoles() {
		HashSet<Integer> bikini = new HashSet<>();
		bikini.add(0);
		return bikini;
	}

}
