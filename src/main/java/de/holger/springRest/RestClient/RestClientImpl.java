package de.holger.springRest.RestClient;

import org.springframework.web.client.RestTemplate;




public class RestClientImpl implements RestClientI{

	
	public Integer getZahl(){
		Integer ret =0;
		
		RestTemplate restTemplate = new RestTemplate();
		
		Integer inti = restTemplate.getForObject("http://localhost:8090/zahl", Integer.class);
		
		ret = inti *2;
		
		
		
		return ret;
		
		
	}
	

}
