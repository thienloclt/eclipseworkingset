package com.monapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
	@RequestMapping("/home")
	public String home() {		
		return "showGetParams";
	}
	
	@RequestMapping("/homeWithModel")
	public String homeModel(Model model) {
		model.addAttribute("method", "homeModel");
		return "showGetParams";
	}
	
	@RequestMapping("/homeWithRequestParam")
	public String homeRequestParam( Model model,@RequestParam(name="name") String value) {		
		model.addAttribute("method", "homeRequestParam");
		model.addAttribute("value", value );
		return "showGetParams";
	}
	
	@RequestMapping("/home/{name}")
	public String homePathVariable( Model model,@PathVariable(name="name") String value) {
		model.addAttribute("method", "homePathVariable");
		model.addAttribute("value", value);
		return "showGetParams";
	}
	@RequestMapping("/home/{name}/categorie/{cat}")
	public String homePathVariable2( Model model,@PathVariable(name="name") String value, @PathVariable(name="cat") String cat ) {
		model.addAttribute("method", "homePathVariable2");
		model.addAttribute("value", value);
		model.addAttribute("cat", cat);
		return "showGetParams";
	}
	
	@RequestMapping(value="/testpostget",  method=RequestMethod.GET)
	public String testGet(Model model,  @RequestParam(value="value", required=false) String prenom) {
		model.addAttribute("method", "testGet");
		model.addAttribute("value", prenom);
		return "showPostParams";
	}
	
	@RequestMapping(value="/testpostget", method=RequestMethod.POST)
	public String testPost(Model model, @RequestParam("value") String prenom) {
		model.addAttribute("method", "testPost");
		model.addAttribute("value", prenom);
		return "showPostParams";
	}
	
}
