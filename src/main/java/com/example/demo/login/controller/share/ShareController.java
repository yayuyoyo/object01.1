package com.example.demo.login.controller.share;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.ShareForm;

@Controller
public class ShareController {

	@GetMapping("/share")
	public String getShare(@ModelAttribute ShareForm shareForm, Model model) {

		model.addAttribute("contents01", "login/share :: share_contents");

		model.addAttribute("radioItems1", shareForm.getRadio1());
		model.addAttribute("radioItems2", shareForm.getRadio2());
		model.addAttribute("radioItems3", shareForm.getRadio3());
		model.addAttribute("radioItems4", shareForm.getRadio4());
		model.addAttribute("radioItems5", shareForm.getRadio5());
		model.addAttribute("radioItems6", shareForm.getRadio6());
		model.addAttribute("radioItems7", shareForm.getRadio7());
		model.addAttribute("radioItems8", shareForm.getRadio8());
		model.addAttribute("radioItems9", shareForm.getRadio9());

		return "login/homeLayout";

	}

	@PostMapping("/share")
	public String postShare(@ModelAttribute ShareForm shareForm, Model model) {

		model.addAttribute("contents01", "login/shareResult :: shareResult_contents");

		String o = "o";
		String x = "x";
		String na = "-";
		int count = 0;

		if (shareForm.getQuestionRadio()[0] == null) {
			model.addAttribute("a01", na);
		} else if (shareForm.getQuestionRadio()[0].equals("1")) {
			model.addAttribute("a01", o);
			count++;
		} else {
			model.addAttribute("a01", x);
		}

		if (shareForm.getQuestionRadio()[1] == null) {
			model.addAttribute("a02", na);
		} else if (shareForm.getQuestionRadio()[1].equals("2")) {
			model.addAttribute("a02", o);
			count++;
		} else {
			model.addAttribute("a02", x);
		}

		if (shareForm.getQuestionRadio()[2] == null) {
			model.addAttribute("a03", na);
		} else if (shareForm.getQuestionRadio()[2].equals("2")) {
			model.addAttribute("a03", o);
			count++;
		} else {
			model.addAttribute("a03", x);
		}

		if (shareForm.getQuestionRadio()[3] == null) {
			model.addAttribute("a04", na);
		} else if (shareForm.getQuestionRadio()[3].equals("3")) {
			model.addAttribute("a04", o);
			count++;
		} else {
			model.addAttribute("a04", x);
		}

		if (shareForm.getQuestionRadio()[4] == null) {
			model.addAttribute("a05", na);
		} else if (shareForm.getQuestionRadio()[4].equals("1")) {
			model.addAttribute("a05", o);
			count++;
		} else {
			model.addAttribute("a05", x);
		}

		if (shareForm.getQuestionRadio()[5] == null) {
			model.addAttribute("a06", na);
		} else if (shareForm.getQuestionRadio()[5].equals("1")) {
			model.addAttribute("a06", o);
			count++;
		} else {
			model.addAttribute("a06", x);
		}

		if (shareForm.getQuestionRadio()[6] == null) {
			model.addAttribute("a07", na);
		} else if (shareForm.getQuestionRadio()[6].equals("4")) {
			model.addAttribute("a07", o);
			count++;
		} else {
			model.addAttribute("a07", x);
		}

		if (shareForm.getQuestionRadio()[7] == null) {
			model.addAttribute("a08", na);
		} else if (shareForm.getQuestionRadio()[7].equals("2")) {
			model.addAttribute("a08", o);
			count++;
		} else {
			model.addAttribute("a08", x);
		}

		if (shareForm.getQuestionRadio()[8] == null) {
			model.addAttribute("a09", na);
		} else if (shareForm.getQuestionRadio()[8].equals("3")) {
			model.addAttribute("a09", o);
			count++;
		} else {
			model.addAttribute("a09", x);
		}

		model.addAttribute("count", count);

		return "login/homeLayout";
	}

}
