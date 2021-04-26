package com.platzi.market.domain.dto;

public class AuthenticationRespose {
	private String jwt;

	public AuthenticationRespose(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

}
