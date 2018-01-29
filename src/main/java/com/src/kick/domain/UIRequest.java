package com.src.kick.domain;

import java.util.Map;

public class UIRequest {

	private String url;
	private Map paramaters;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map getParamaters() {
		return paramaters;
	}
	public void setParamaters(Map paramaters) {
		this.paramaters = paramaters;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paramaters == null) ? 0 : paramaters.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UIRequest other = (UIRequest) obj;
		if (paramaters == null) {
			if (other.paramaters != null)
				return false;
		} else if (!paramaters.equals(other.paramaters))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "UIRequest [url=" + url + ", paramaters=" + paramaters + "]";
	}
	
	
}
