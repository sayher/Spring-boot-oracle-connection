package com.frontendauthentication.dataSource;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class OracleDatasourceConfig extends HikariConfig {
	@Bean(name = { "OracleDatasource" })
	@Primary
	public DataSource OracleDataSource() {
		return new HikariDataSource(this);
	}

	@Bean("jdbcTemplateOracle")
	public JdbcTemplate createJdbcTemplate(@Autowired @Qualifier("OracleDatasource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
