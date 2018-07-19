package com.milkyway.SpringUserREST;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
	
	//Greeting object converted into JSON String internally
	
	@GetMapping("/greeting/{name}")
	public Greeting getGreeting(@PathVariable(value="name",required=false) String name) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, name));
	}
}
