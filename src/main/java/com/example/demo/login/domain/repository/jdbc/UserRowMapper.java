package com.example.demo.login.domain.repository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.login.domain.model.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User user = new User();
		user.setUserName(rs.getString("user_name"));
		user.setPassword(rs.getString("password"));
		user.setMailAddress(rs.getString("mailAddress"));
		//user.setBirthday(rs.getDate("birthday"));
		user.setGender(rs.getBoolean("gender"));
		user.setRole(rs.getString("role"));

		return user;
	}

}
