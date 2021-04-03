package com.example.demo.login.controller.weight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.Record;
import com.example.demo.login.domain.model.RecordForm;
import com.example.demo.login.domain.service.WeightService;

@Controller
public class WeightController {

	@Autowired
	WeightService weightService;

	@GetMapping("/weight")
	public String getWeight(Model model) {

		model.addAttribute("contents01", "login/weight :: weight_contents");

		List<RecordForm> weightList = weightService.selectMany();
		model.addAttribute("weightList", weightList);

		int count = weightService.count();
		model.addAttribute("weightListCount", count);

		return "login/homeLayout";
	}

//	@PostMapping(value = "/weight", params = "delete")
//	public String postWeightDelete(@ModelAttribute RecordForm recordForm, Model model) {
//
//		System.out.println("削除実行");
//
//		boolean result = weightService.deleteAll(recordForm.getConvertedDate());
//
//		if (result == true) {
//			System.out.println("削除OK");
//		} else {
//			System.out.println("削除NG");
//		}
//
//		return "redirect:/weight";
//	}
	
	@PostMapping(value = "/weight", params = "deleteOne")
	public String postWeightDeleteOne(@ModelAttribute RecordForm recordForm, Model model) {

		System.out.println("一件削除実行");
		System.out.println(recordForm.getRecordId());

		boolean result = weightService.deleteOne(recordForm.getRecordId());

		if (result == true) {
			System.out.println("一件削除OK");
		} else {
			System.out.println("一件削除NG");
		}

		return "redirect:/weight";
	}

}
