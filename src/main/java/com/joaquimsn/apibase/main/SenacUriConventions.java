package com.joaquimsn.apibase.main;

public abstract class SenacUriConventions {

	private SenacUriConventions() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String BASE_URL_API = "/api";
	public static final String BASE_URL_PUBLIC_API = "/api/public";
	public static final String BASE_URL_API_AUTH = "/api/auth";
}
