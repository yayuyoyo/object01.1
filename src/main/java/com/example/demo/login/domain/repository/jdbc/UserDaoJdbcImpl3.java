package com.example.demo.login.domain.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.demo.login.domain.model.User;

public class UserDaoJdbcImpl3 extends UserDaoJdbcImpl {

	@Autowired
	private JdbcTemplate jdbc;

	@Override
	public User selectOne(String userName) throws DataAccessException {

		String sql = "SELECT * FROM m_user WHERE user_name = ?";

		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);

		return jdbc.queryForObject(sql, rowMapper, userName);
	}

}
