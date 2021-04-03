package com.example.demo.login.domain.repository;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.demo.login.domain.model.Record;
import com.example.demo.login.domain.model.RecordForm;
import com.example.demo.login.domain.model.User;

public interface WeightDao {

	public RecordForm selectOne(String recordYear) throws DataAccessException;

	public int insertOne(RecordForm recordForm) throws DataAccessException;

	public int count() throws DataAccessException;

	public List<RecordForm> selectMany() throws DataAccessException;

	public int deleteAll(Date recordDate) throws DataAccessException;

	public int deleteOne(int recordId) throws DataAccessException;

}
