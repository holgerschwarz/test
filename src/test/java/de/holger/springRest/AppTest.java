package de.holger.springRest;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultHandler;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
 

/**
 * Unit test for simple App.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest
public class AppTest {
    

@Autowired
private WebApplicationContext webApplicationContext;

 //   @Test
    public void homepageTest(){
    	//given
    	RestTemplate restTemplate = new RestTemplate();
    	
    	//when
    	String string = restTemplate.getForObject("http://localhost:8888/", String.class);
    	
    	//then
    	assertEquals("let's.",string);
 
    	
    	
    }

@Test
public void restMockMvcTest() throws Exception{
	MockMvc mockMvc = webAppContextSetup(webApplicationContext).build(); 
	mockMvc.perform(get("")).andExpect(status().isOk())
	.andExpect(content().string("let's."))
	.andExpect(content().contentType("text/plain;charset=UTF-8"));

}


@Test
public void restAloneTest() throws Exception{
	MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webApplicationContext).build(); 
	mockMvc.perform(get("")).andExpect(status().isOk())
	.andExpect(content().string("let's."))
	.andExpect(content().contentType("text/plain;charset=UTF-8"));

}

}
