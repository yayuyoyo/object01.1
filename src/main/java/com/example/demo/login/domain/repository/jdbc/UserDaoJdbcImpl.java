package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.repository.UserDao;

@Repository("UserDaoJdbcImpl")
public class UserDaoJdbcImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public int count() throws DataAccessException {

		int count = jdbc.queryForObject("select count(*) from m_user", Integer.class);

		return count;
	}

	@Override
	public int insertOne(User user) throws DataAccessException {

		String password = passwordEncoder.encode(user.getPassword());

		int rowNumber = jdbc.update(
				"INSERT INTO m_user(user_name," + " password," + " mailAddress," + " birthYear," + " birthMonth,"
						+ " birthday," + " gender," + " role)" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?)",
				user.getUserName(), password, user.getMailAddress(), user.getBirthYear(), user.getBirthMonth(),
				user.getBirthday(), user.isGender(), user.getRole());
		return rowNumber;// 登録したレコード数(この場合、"8"が返ってくるはず)
	}

	@Override
	public User selectOne(String userName) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public List<User> selectMany() throws DataAccessException {

		List<Map<String, Object>> getList = jdbc.queryForList("select * from m_user");

		List<User> userList = new ArrayList<>();

		for (Map<String, Object> map : getList) {

			User user = new User();

			user.setUserName((String) map.get("user_name"));
			user.setPassword((String) map.get("password"));
			user.setMailAddress((String) map.get("mailAddress"));
			user.setBirthYear((String) map.get("birthYear"));
			user.setBirthMonth((String) map.get("birthMonth"));
			user.setBirthday((String) map.get("birthday"));
			user.setGender((Boolean) map.get("gender"));
			user.setRole((String) map.get("role"));

			userList.add(user);
		}

		return userList;
	}

	@Override
	public int updateOne(User user) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public int deleteOne(String userName) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

}
