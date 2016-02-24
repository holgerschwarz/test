package de.holger.springRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import de.holger.springRest.Configuration.RestConfiguration;
import de.holger.springRest.RestClient.RestClientI;


 
@Configuration
@ContextConfiguration(classes=RestConfiguration.class)
public class AppController {

	
	@Autowired
	private  RestClientI  restClient;
	
	private void controller(){
		/*AnnotationConfigApplicationContext ctx;
 
	    	ctx = new AnnotationConfigApplicationContext();
	    	ctx.register(AppContext.class);    	
	        ctx.refresh();
	        ctx.start();
	        
	        ctx.getBean(UserTaskService.class)*/
	        
		Integer i = restClient.getZahl();
		
		System.out.println("zahl = " + i);
	}
	
    public static void main( String[] args ) {
    	
    	AppController appController = new AppController();
    	appController.controller();
		
	}
}
