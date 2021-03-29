package com.example.demo.login.domain.repository.jdbc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Record;
import com.example.demo.login.domain.model.RecordForm;
import com.example.demo.login.domain.repository.WeightDao;

@Repository("WeightDaoJdbcImpl")
public class WeightDaoJdbcImpl implements WeightDao {

	@Autowired
	JdbcTemplate jdbc;

	@Override
	public RecordForm selectOne(String recordYear) throws DataAccessException {

		Map<String, Object> map = jdbc.queryForMap("SELECT * FROM w_data" + " WHERE recordYear = ?", recordYear);

		RecordForm recordForm = new RecordForm();
//		recordForm.setRecordYear((String) map.get("recordYear"));
//		recordForm.setRecordMonth((String) map.get("recordMonth"));
//		recordForm.setRecordDay((String) map.get("recordDay"));
		recordForm.setRecordWeight((Double) map.get("recordWeight"));

		return recordForm;

	}

//	public int insertOnes(RecordForm recordForm) throws DataAccessException {
//		int rowNumber = jdbc.update("INSERT INTO d_data(sqlDate)" + " VALUES(?)", recordForm.getSqlDate());
//		return rowNumber;
//	}

	@Override
	public int insertOne(RecordForm recordForm) throws DataAccessException {

		int rowNumber = jdbc.update("INSERT INTO w_data (RECORDDATE," + " recordWeight)" + " VALUES(?,?)",
				recordForm.getSqlDate(), recordForm.getWeight());

//		int rowNumber = jdbc.update(
//				"INSERT INTO w_data(recordYear," + " recordMonth," + " recordDay," + " recordWeight)"
//						+ " VALUES(?, ?, ?, ?)",
//				recordForm.getRecordYear(), recordForm.getRecordMonth(), recordForm.getRecordDay(),
//				recordForm.getWeight());
		return rowNumber;// 登録したレコード数(この場合、"4"が返ってくるはず)
	}

	@Override
	public int count() throws DataAccessException {

		int count = jdbc.queryForObject("select count(*) from w_data", Integer.class);

		return count;
	}

	@Override
	public List<RecordForm> selectMany() throws DataAccessException {

		List<Map<String, Object>> getList = jdbc.queryForList("select * from w_data");

		List<RecordForm> recordList = new ArrayList<>();

		for (Map<String, Object> map : getList) {

			RecordForm recordForm = new RecordForm();

//			recordForm.setRecordYear((String) map.get("recordYear"));
//			recordForm.setRecordMonth((String) map.get("recordMonth"));
//			recordForm.setRecordDay((String) map.get("recordDay"));
			recordForm.setSqlDate((Date)map.get("recordDate"));
			recordForm.setRecordWeight((double) map.get("recordWeight"));

			recordList.add(recordForm);
		}

		return recordList;
	}

	@Override
	public int deleteOne(String recordYear) throws DataAccessException {

		int rowNumber = jdbc.update("DELETE FROM w_data WHERE recordYear = ?", recordYear);

		return rowNumber;
	}

}
