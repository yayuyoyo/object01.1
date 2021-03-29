package com.example.demo.login.controller.editor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EditorController {

	@GetMapping("/editor")
	public String getEditor(Model model) {

		model.addAttribute("contents01", "login/editor :: editor_contents");

		return "login/homeLayout";
	}
	/*
	 * @PostMapping("/editor") public String postEditor() { return "redirect:/home";
	 * }
	 */

}
