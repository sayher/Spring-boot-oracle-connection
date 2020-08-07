package com.frontendauthentication.service;

import com.frontendauthentication.model.AuthResponseModel;

public interface AuthService {
	public AuthResponseModel Authentication(String username, String password);
}
