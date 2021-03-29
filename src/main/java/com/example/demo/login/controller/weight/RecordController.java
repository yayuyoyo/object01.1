package com.example.demo.login.controller.weight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.RecordForm;
import com.example.demo.login.domain.service.WeightService;

@Controller
public class RecordController {

	@Autowired
	WeightService weightService;

	@GetMapping("/record")
	public String getRecord(@ModelAttribute RecordForm recordForm, Model model) {

		model.addAttribute("contents01", "login/record :: record_contents");

		return "login/homeLayout";
	}

	@PostMapping("/record")
	public String postRecord(@ModelAttribute RecordForm recordForm, BindingResult bindingResult, Model model) {

		model.addAttribute("contents01", "login/weight :: weight_contents");

		if (bindingResult.hasErrors()) {
			return getRecord(recordForm, model);
		}
		System.out.println("recordFormの中身を確認 → \n" + recordForm);

		boolean result = weightService.insert(recordForm);
		if (result == true) {
			System.out.println("insert成功");
		} else {
			System.out.println("insert失敗");
		}

		return "redirect:/weight";
	}

}
