package com.frontendauthentication.repository;

import com.frontendauthentication.model.AuthResponseModel;

public interface AuthRepository {
	
	public AuthResponseModel Authentication(String username, String password);
}
