package org.forkjoin.jteach.open.client.api;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.Future;

import org.forkjoin.apikit.client.*;

import org.forkjoin.apikit.core.Result;
import org.forkjoin.jteach.open.client.form.LoginForm;

/**
 * @author  zuoge85 on 15/6/11.
 */
public class AccountApi {
	private HttpClientAdapter httpClientAdapter;

	public AccountApi(HttpClientAdapter httpClientAdapter) {
		this.httpClientAdapter = httpClientAdapter;
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>login</b>
	 * <ul>
	 * <li><b>Form:</b>LoginFormlogin</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see LoginForm

	 */
	public String loginData(LoginForm form) {
		Result<String> result = login(form);
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			if (ex != null) {
				throw new RuntimeException(ex.getMessage(), ex);
			} else {
				throw new RuntimeException(result.toString());
			}
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>login</b>
	 * <ul>
	 * <li><b>Form:</b>LoginFormlogin</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see LoginForm

	 */
	public Result<String> login(LoginForm form) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("login", _uriVariables);

		List<Entry<String, Object>> _form = form.encode("", new ArrayList<Entry<String, Object>>());
		return httpClientAdapter.<Result<String>, String> request("POST", _url, _form, _0Type, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>login</b>
	 * <ul>
	 * <li><b>Form:</b>LoginFormlogin</li>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String
	 * @see LoginForm

	 */
	public Future<?> login(LoginForm form, Callback<Result<String>, String> callable) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("login", _uriVariables);

		List<Entry<String, Object>> _form = form.encode("", new ArrayList<Entry<String, Object>>());
		return httpClientAdapter.requestAsync("POST", _url, _form, _0Type, false, callable);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>status</b>
	 * <ul>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String

	 */
	public String statusData() {
		Result<String> result = status();
		if (!result.isSuccess()) {
			Exception ex = result.getException();
			if (ex != null) {
				throw new RuntimeException(ex.getMessage(), ex);
			} else {
				throw new RuntimeException(result.toString());
			}
		}
		return result.getData();
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>status</b>
	 * <ul>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String

	 */
	public Result<String> status() {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("status", _uriVariables);

		return httpClientAdapter.<Result<String>, String> request("GET", _url, null, _1Type, false);
	}

	/**
	 * 
	 *
	 * <div class='http-info'>http 说明：<b>Api Url:</b> <b>status</b>
	 * <ul>
	 * <li><b>Model:</b> String</li>
	 * </ul>
	 * </div>
	 * @see String

	 */
	public Future<?> status(Callback<Result<String>, String> callable) {
		Map<String, Object> _uriVariables = new HashMap<>();
		String _url = ApiUtils.expandUriComponent("status", _uriVariables);

		return httpClientAdapter.requestAsync("GET", _url, null, _1Type, false, callable);
	}

	private static final ApiType _0Type = ApiUtils.type(Result.class, ApiUtils.type(String.class));
	private static final ApiType _1Type = ApiUtils.type(Result.class, ApiUtils.type(String.class));
}