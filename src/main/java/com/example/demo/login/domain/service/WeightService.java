package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Record;
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
	
	public boolean inserts(RecordForm recordForm) {
		int rowNumber = dao.insertOne(recordForm);
		boolean result = false;
		if (rowNumber > 0) {
			result = true;
		}

		return result;
	}

	/*
	 * public boolean insert(Record record) { int rowNumber = dao.insertOne(record);
	 * boolean result = false; if (rowNumber > 0) { result = true; }
	 * 
	 * return result; }
	 */

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

	public boolean deleteOne(String recordYear) {

		int rowNumber = dao.deleteOne(recordYear);

		boolean result = false;

		if (rowNumber > 0) {
			result = true;
		}
		return result;
	}

}
