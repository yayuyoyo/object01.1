package com.example.demo.login.controller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
public class MemberController {

	@Autowired
	UserService userService;

	@GetMapping("/member")
	public String getMember(Model model) {

		model.addAttribute("contents01", "login/member :: member_contents");

		List<User> memberList = userService.selectMany();
		model.addAttribute("memberList", memberList);
		
		int count = userService.count();
		model.addAttribute("memberListCount", count);

		return "login/homeLayout";
	}

}
