package com.example.demo.login.domain.model;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Record {

	private String recordYear;
	private String recordMonth;
	private String recordDay;

	private double recordWeight;
	
	/*
	public Map<String, String> getYear() {
		Map<String, String> yearMap = new LinkedHashMap<String, String>();
		for (int i = 2021; i >= 1995; i--) {
			yearMap.put(String.valueOf(i), String.valueOf(i));

		}
		return yearMap;
	}
	
	public Map<String, String> getMonth() {
		Map<String, String> monthMap = new LinkedHashMap<String, String>();
		for (int i = 1; i <= 12; i++) {
			monthMap.put(String.valueOf(i), String.valueOf(i));
		}
		return monthMap;
	}
	
	public Map<String, String> getDay() {
		Map<String, String> dayMap = new LinkedHashMap<String, String>();
		for (int i = 1; i <= 31; i++) {
			dayMap.put(String.valueOf(i), String.valueOf(i));
		}
		return dayMap;
	}
	
	public double getWeight() {
		double weightDecimalPoint = ((double)Math.round(recordWeight * 10) /10);
		return weightDecimalPoint;
	}
	*/
}
