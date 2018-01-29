package com.src.kick.domain;

import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.http.HttpMethod;

public class RestRequest {
	
	
	private String url;
	private HttpMethod method;
	private Map<String,String> pathParams;
	private Map<String,String> queryParams;
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HttpMethod getMethod() {
		return method;
	}
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	public Map<String, String> getPathParams() {
		return pathParams;
	}
	public void setPathParams(Map<String, String> pathParams) {
		this.pathParams = pathParams;
	}
	public Map<String, String> getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(Map<String, String> queryParams) {
		this.queryParams = queryParams;
	}
	
	
}
