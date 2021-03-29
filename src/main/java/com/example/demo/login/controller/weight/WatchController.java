package com.example.demo.login.controller.weight;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WatchController {
	
	@GetMapping("/watch")
	public String getWatch(Model model) {
		
		model.addAttribute("contents01", "login/watch :: watch_contents");
		
		return "login/homeLayout";
	}

}
