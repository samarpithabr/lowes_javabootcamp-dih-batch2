package com.labs.spring.rest;



import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {	

	@RequestMapping(value = "/greetings", method = RequestMethod.GET, params = { "msg" })
   public String greetings() {
	return "hello string rest";
	
}
	@RequestMapping(value = "/greetings", method = RequestMethod.POST, consumes = { "application/xml"
}, produces = { "application/xml" })
public Greetings postGreetingObject(@RequestBody Greetings greeting) {
greeting.setMessage(greeting.getMessage() + " - takes bothPOST object mapping example");
return greeting;
}


}
	

