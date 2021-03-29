package com.example.demo.login.domain.model;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class SignupForm {

	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 8, max = 20, groups = ValidGroup2.class)
	@Pattern(regexp = "[a-zA-Z0-9]+$", groups = ValidGroup3.class)
	private String userName;

	@NotBlank(groups = ValidGroup1.class)
	@Length(min = 4, max = 4, groups = ValidGroup2.class)
	@Pattern(regexp = "[0-9]+$", groups = ValidGroup3.class)
	private String password;

	@NotBlank(groups = ValidGroup1.class)
	@Email(groups = ValidGroup2.class)
	private String mailAddress;

	@NotBlank(groups = ValidGroup1.class)
	private String birthYear;

	@NotBlank(groups = ValidGroup1.class)
	private String birthMonth;

	// @NotNull(groups = ValidGroup1.class)
	// @DateTimeFormat(pattern = "yyyy/MM/dd")
	// private Date birthday;
	@NotBlank(groups = ValidGroup1.class)	
	private String birthday;

	private boolean gender;

	public Map<String, String> getYear() {
		Map<String, String> yearMap = new LinkedHashMap<String, String>();
		for (int i = 2021; i >= 1900; i--) {
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

}
