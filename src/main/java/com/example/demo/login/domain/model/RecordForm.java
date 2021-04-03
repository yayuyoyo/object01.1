package com.example.demo.login.domain.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;

@Data
public class RecordForm {
	
	private int recordId;

	Date date = new Date();

	SimpleDateFormat year = new SimpleDateFormat("yyyy");
	private String recordYear = year.format(date);

	SimpleDateFormat month = new SimpleDateFormat("MM");
	private String recordMonth = month.format(date);

	SimpleDateFormat day = new SimpleDateFormat("dd");
	private String recordDay = day.format(date);

	private Date sqlDate;
	
	private double recordWeight;

//	public int getIncrementId() {
//
//		return recordId;
//	}

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
			monthMap.put(String.format("%02d", i), String.format("%02d", i));
		}
		return monthMap;
	}

	public Map<String, String> getDay() {
		Map<String, String> dayMap = new LinkedHashMap<String, String>();
		for (int i = 1; i <= 31; i++) {
			dayMap.put(String.format("%02d", i), String.format("%02d", i));
		}
		return dayMap;
	}

	public Date getConvertedDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
		try {
			sqlDate = simpleDateFormat.parse(this.recordYear + this.recordMonth + this.recordDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;
	}

	public double getWeight() {
		double weightDecimalPoint = ((double) Math.round(recordWeight * 10) / 10);
		return weightDecimalPoint;
	}

}
