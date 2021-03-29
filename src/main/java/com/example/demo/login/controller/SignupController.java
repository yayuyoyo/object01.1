package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.GroupOrder;
import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;


@Controller
public class SignupController {

	@Autowired
	private UserService userService;

	private Map<String, String> radioGender;

	private Map<String, String> initRadioGender() {

		Map<String, String> radio = new LinkedHashMap<>();

		radio.put("男", "true");
		radio.put("女", "false");

		return radio;
	}

	@GetMapping("/signup")
	public String getSignup(@ModelAttribute SignupForm form, Model model) {

		radioGender = initRadioGender();

		model.addAttribute("radioGender", radioGender);

		return "login/signup"; // templates配下パス
	}

	@PostMapping("/signup")
	public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return getSignup(form, model);
		}
		System.out.println("formの中身を確認 → \n" + form);

		User user = new User();
		user.setUserName(form.getUserName());
		user.setPassword(form.getPassword());
		user.setMailAddress(form.getMailAddress());
		user.setBirthYear(form.getBirthYear());
		user.setBirthMonth(form.getBirthMonth());
		user.setBirthday(form.getBirthday());
		user.setGender(form.isGender());
		user.setRole("ROLE_GENERAL");

		boolean result = userService.insert(user);
		if (result == true) {
			System.out.println("insert成功");
		} else {
			System.out.println("insert失敗");
		}

		return "redirect:/login";
	}

}
