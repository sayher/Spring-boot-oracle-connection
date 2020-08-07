package com.frontendauthentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponseModel {

	private String USER_NAME;
	private String BRANCH_CODE;
	private String NAME;

}
