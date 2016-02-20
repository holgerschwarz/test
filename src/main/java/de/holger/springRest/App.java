package de.holger.springRest;

import org.apache.coyote.http11.Http11AprProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@RestController
public class App 
{
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public String hello(){
		System.out.println("*****************   hello   *************");
		return "let's.";
	}
	
    public static void main( String[] args )
    {
    	
    	SpringApplication.run(App.class, args);
    }
}
