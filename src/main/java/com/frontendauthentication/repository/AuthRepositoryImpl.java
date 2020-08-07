package com.frontendauthentication.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frontendauthentication.model.AuthResponseModel;

@Transactional
@Repository
public class AuthRepositoryImpl implements AuthRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public AuthResponseModel Authentication(String username, String password) {
		AuthResponseModel response = null;
		try {
			String sql = "SELECT user_name,password,branch_code,name FROM tbl_user where user_name=? and password=?";
			RowMapper<AuthResponseModel> rowMapper = new BeanPropertyRowMapper<AuthResponseModel>(
					AuthResponseModel.class);
			response = jdbcTemplate.queryForObject(sql, rowMapper, username, password);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return response;
	}

}
