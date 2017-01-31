package br.com.alexandreafonso.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CasaController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/gerente")
	public String gerente() {
		return "gerente";
	}
	
	@GetMapping("/desenvolvedor")
	public String desenvolvedor() {
		return "desenvolvedor";
	}
}