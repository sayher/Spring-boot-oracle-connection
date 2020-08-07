package com.frontendauthentication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frontendauthentication.model.AuthResponseModel;
import com.frontendauthentication.model.ResponseMessageModel;
import com.frontendauthentication.service.AuthenticationService;

@RestController

public class AuthenticationController {
	public static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationService authService;

	@GetMapping("/hello")
	public String Hello() {
		return "Hello Word";
	}
	
	@PostMapping("/authentication")
	public ResponseMessageModel Login(@RequestParam("USER_ID") String USER_ID,
			@RequestParam("PASSWORD") String PASSWORD) {
		ResponseMessageModel resMessage = null;
		AuthResponseModel data = null;
		try {
			data = authService.Authentication(USER_ID, PASSWORD);
			if (data == null || data.equals(null)) {
				resMessage = new ResponseMessageModel(false, "Invalid username or password", data);
				//System.out.println("data null");
			} else {
				resMessage = new ResponseMessageModel(true, "Success", data);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			resMessage = new ResponseMessageModel(false, "Invalid username or password", data);
			logger.error("Invalid user and password || " +e.getMessage() );
		}

		return resMessage;

	}

}
