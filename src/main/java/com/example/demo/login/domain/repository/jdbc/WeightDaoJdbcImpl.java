package com.example.demo.login.domain.repository.jdbc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

	@Override
	public int insertOne(RecordForm recordForm) throws DataAccessException {

//		int rowNumber = jdbc.update("INSERT INTO w_data (id," + " recordDate," + " recordWeight)" + " VALUES(?,?,?)",
//				recordForm.getRecordId(), recordForm.getConvertedDate(), recordForm.getWeight());
		
		int rowNumber = jdbc.update("INSERT INTO w_data (recordDate," + " recordWeight)" + " VALUES(?,?)",
				 recordForm.getConvertedDate(), recordForm.getWeight());

		return rowNumber;
	}

	@Override
	public int count() throws DataAccessException {

		int count = jdbc.queryForObject("select count(*) from w_data", Integer.class);

		return count;
	}

	@Override
	public List<RecordForm> selectMany() throws DataAccessException {

		List<Map<String, Object>> getList = jdbc.queryForList("select * from w_data ORDER BY recordDate desc");

		List<RecordForm> recordList = new ArrayList<>();

		for (Map<String, Object> map : getList) {

			RecordForm recordForm = new RecordForm();
			recordForm.setRecordId((int) map.get("id"));
			recordForm.setSqlDate((Date) map.get("recordDate"));
			recordForm.setRecordWeight((double) map.get("recordWeight"));

			recordList.add(recordForm);
		}

		return recordList;
	}

	@Override
	public int deleteAll(Date recordDate) throws DataAccessException {

		int rowNumber = jdbc.update("DELETE FROM w_data WHERE recordDate = ?", recordDate);

		return rowNumber;
	}

	@Override
	public int deleteOne(int recordId) throws DataAccessException {

		int rowNumber = jdbc.update("DELETE FROM w_data WHERE id = ?", recordId);

		return rowNumber;
	}

}
