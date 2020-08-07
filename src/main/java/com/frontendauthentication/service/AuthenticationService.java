package com.frontendauthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frontendauthentication.model.AuthResponseModel;
import com.frontendauthentication.repository.AuthRepositoryImpl;

@Service
public class AuthenticationService implements AuthService {

	@Autowired
	private AuthRepositoryImpl repo;

	@Override
	public AuthResponseModel Authentication(String username, String password) {

		return repo.Authentication(username, password);
	}

}
