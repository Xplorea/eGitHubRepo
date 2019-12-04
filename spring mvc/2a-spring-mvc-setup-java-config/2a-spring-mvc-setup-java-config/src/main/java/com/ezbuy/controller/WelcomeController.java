package com.ezbuy.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class WelcomeController {
	@GetMapping("/welcome")

	public ModelAndView getMessage() {
		ModelAndView modelAndView = new ModelAndView(
				"welcome", "message",
				"Welcome to Spring MVC!");
		return modelAndView;
	}
}
