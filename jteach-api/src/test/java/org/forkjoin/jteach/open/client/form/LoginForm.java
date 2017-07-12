package org.forkjoin.jteach.open.client.form;

import org.forkjoin.apikit.core.*;

import java.util.*;
import java.util.Map.Entry;
import java.util.AbstractMap.SimpleImmutableEntry;

/**
 * @author  zuoge85@gmail.com on 2017/6/6.
 */
public class LoginForm implements ApiMessage {

	/**
	 * 秘钥id
	 */
	private String name;

	/**
	 * 秘钥值
	 */
	private String password;

	public LoginForm() {
	}

	public LoginForm(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/**
	 * 秘钥id
	 */
	public String getName() {
		return name;
	}

	/**
	 * 秘钥id
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 秘钥值
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 秘钥值
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public List<Entry<String, Object>> encode(String $parent, List<Entry<String, Object>> $list) {

		if (name != null) {
			$list.add(new SimpleImmutableEntry<String, Object>($parent + "name", name));
		}

		if (password != null) {
			$list.add(new SimpleImmutableEntry<String, Object>($parent + "password", password));
		}

		return $list;
	}

	@Override
	public String toString() {
		return "LoginForm [name=" + name + ",password=" + password + ", ]";
	}
}