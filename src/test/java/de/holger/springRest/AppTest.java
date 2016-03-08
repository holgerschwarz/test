package de.holger.springRest;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
 

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest
public class AppTest {
    

private static final String HTTP_LOCALHOST = "http://localhost:8090/";
@Autowired
private WebApplicationContext webApplicationContext;

private RestTemplate restTemplate;
private MockRestServiceServer mockServer;

@Before
public void setUp() {
	restTemplate = new RestTemplate();
 
	mockServer = MockRestServiceServer.createServer(restTemplate);
}

    @Test
    public void homepageTest(){
    	//given
    	RestTemplate restTemplate = new RestTemplate();
    	
    	//when
    	String string = restTemplate.getForObject(HTTP_LOCALHOST, String.class);
    	
    	//then
    	assertEquals("let's.",string);
 
    	
    	
    }

@Test
public void restMockMvcHomepageTest() throws Exception{
	MockMvc mockMvc = webAppContextSetup(webApplicationContext).build(); 
	mockMvc.perform(get("")).andExpect(status().isOk())
	.andExpect(content().string("let's."))
	.andExpect(content().contentType("text/plain;charset=UTF-8"));

}

@Test
public void restMockRestServiceServerTest()   {
	//Given
 
	
	mockServer
		.expect(requestTo(""))
		.andExpect(method(HttpMethod.GET))
		// Der Response wird ausgemockt, deshalb erzeugen wir hier einen Dummy-Response
		.andRespond(withSuccess("test", MediaType.APPLICATION_JSON));
			
	//When
	String str = restTemplate.getForObject("", String.class);
	
	//Then	
	assertEquals("was",str);
	mockServer.verify();
}


@Test
public void restGetZahl(){
	
	RestTemplate restTemplate = new RestTemplate();
	Integer inti = restTemplate.getForObject(HTTP_LOCALHOST +"zahl", Integer.class);
	
	assertEquals(new Integer(2), inti);

}

}
