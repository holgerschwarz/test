package de.holger.springRest.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.holger.springRest.RestClient.RestClientI;
import de.holger.springRest.RestClient.RestClientImpl;

//@Configuration
public class RestConfiguration {
 
    //@Autowired
	//@Bean
	public   RestClientI restClient(){
		return new RestClientImpl();
	}
}
