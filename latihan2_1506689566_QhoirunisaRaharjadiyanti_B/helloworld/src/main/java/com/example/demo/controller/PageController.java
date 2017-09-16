package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

public class PageController
{
	@RequestMapping("/hello")
	public String index ()
	{
		return "hello";
	}
	
//	@RequestMapping("/greeting")
//	public String greeting (@RequestParam(value = "name") String name, Model model)
//	{
//	model.addAttribute ("name", name);
//	return "greeting";
//	}
	
	@RequestMapping(value = {"/greeting", "greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
	if (name.isPresent()) {
	model.addAttribute("name", name.get());
	} else {
	model.addAttribute("name", "dengklek");
	}
	return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String perkalian (@RequestParam (value = "a", required = false,
			defaultValue = "0") String a, @RequestParam(value = "b", required = false,
			defaultValue = "0") String b, Model model)
	{
	if (a == null) {
		model.addAttribute ("a", 0);
		model.addAttribute ("b", 0);
	} else {
		if (a != null) {
			model.addAttribute ("a", a);
			if (b == null) {
				model.addAttribute ("b", 0);
			} else {
				model.addAttribute ("b", b);
			}
		}
		
	}
	
	return "perkalian";
	}



}
