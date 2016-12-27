package ch.bharanya.jrnl_manager.controller;

import com.google.gson.Gson;

public class TestResponse {

	public final String body;
	public final int status;

	public TestResponse(final int status, final String body) {
		this.status = status;
		this.body = body;
	}

	public <T> T getJson(final Class<T> clazz) {
		return new Gson().fromJson(body, clazz);
	}
}