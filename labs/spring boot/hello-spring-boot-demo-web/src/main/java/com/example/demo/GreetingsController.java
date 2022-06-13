package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

	    @GetMapping("/greetings")
	    public String greetings() {
	        return "Welcome to Spring Boot Web App";
	    }
	    @GetMapping("/siri")
	    public String siri() {
	    	return "i am going to see my daughter";
	    }
	    @GetMapping("/sharath")
	    public String sharath(){
			return "finally all of us are together";
	    	
	    }
	}
	 