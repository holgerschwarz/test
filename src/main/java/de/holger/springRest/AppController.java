package de.holger.springRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

import de.holger.springRest.Configuration.RestConfiguration;
import de.holger.springRest.RestClient.RestClientI;


 
@Configuration
@ContextConfiguration(classes=RestConfiguration.class)
public class AppController {

	
 
	private  RestClientI  restClient;
	
	@SuppressWarnings("resource")
	private void controllerOhneBean(){
		 	AnnotationConfigApplicationContext ctx;
 
	    	ctx = new AnnotationConfigApplicationContext();
	    	ctx.register(RestConfiguration.class);    	
	        ctx.refresh();
	        ctx.start();
	        
	        RestConfiguration rest = ctx.getBean(RestConfiguration.class) ;
	        
		Integer i =  rest.restClient().getZahl();
		
		System.out.println("zahl = " + i);
	}
	
	private void controllerMitBean(){
 
        
        Integer i = restClient.getZahl();
	
	System.out.println("zahl = " + i);
}
	
    public static void main( String[] args ) {
    	
    	AppController appController = new AppController();
    	appController.controllerMitBean();
		
	}
}
