package com.example.demo.login.domain.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.RecordForm;
import com.example.demo.login.domain.repository.WeightDao;

@Service
public class WeightService {

	public boolean insert(RecordForm recordForm) {
		int rowNumber = dao.insertOne(recordForm);
		boolean result = false;
		if (rowNumber > 0) {
			result = true;
		}

		return result;
	}

	@Autowired
	@Qualifier("WeightDaoJdbcImpl")
	WeightDao dao;

	public int count() {

		return dao.count();

	}

	public RecordForm selectOne(String recordYear) {

		return dao.selectOne(recordYear);
	}

	public List<RecordForm> selectMany() {

		return dao.selectMany();

	}

	public boolean deleteAll(Date recordDate) {

		int rowNumber = dao.deleteAll(recordDate);

		boolean result = false;

		if (rowNumber > 0) {
			result = true;
		}
		return result;
	}

	public boolean deleteOne(int recordId) {

		int rowNumber = dao.deleteOne(recordId);

		boolean result = false;

		if (rowNumber > 0) {
			result = true;
		}
		return result;
	}

}
