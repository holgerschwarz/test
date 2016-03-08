package de.holger.springRest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.holger.springRest.Configuration.RestConfiguration;
import de.holger.springRest.RestClient.RestClientI;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest
//@ContextConfiguration(classes = RestConfiguration.class)

public class AppControllerTest {

	@Autowired
	private RestClientI restClient;

	@Test
	public void controllerOhneBeanSystemTest() {
		Integer i = 0;
		RestConfiguration rc = new RestConfiguration();
		i = rc.restClient().getZahl();
		assertEquals(new Integer(4), i);

	}
	
	@Test
	public void controllerBeanSystemTest() {
		 
		
		 Integer i = restClient.getZahl();

		assertEquals(new Integer(4), i);

	}
}
