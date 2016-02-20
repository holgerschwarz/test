package de.holger.springRest;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@RequestMapping("/service")
	public void hello(){
		System.out.println("rest hello");
	}
	
}
