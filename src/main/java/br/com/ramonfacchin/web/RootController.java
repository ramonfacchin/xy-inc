package br.com.ramonfacchin.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
	
	@RequestMapping("/")
	public String hello() {
		return "Hello!";
	}

}
