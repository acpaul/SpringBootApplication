package com.sample.people.hotel;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.WebFluxAutoConfiguration.WebFluxConfig;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.*;
import com.google.gson.Gson;
import com.sample.people.hotel.Entity.User;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/*@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc */

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = {WebFluxConfig.class})
public class UserRestControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void saveTest1() throws Exception
    {	
		 User u1 = new User();
    	 u1.setUserName("ac.p3");
    	 u1.setFirstName("alex");
    	 u1.setLastName("Paul");
    	 u1.setEmail("a@gmail.com");
    	 //u1.setPassword("123456789");
    	    Gson gson = new Gson();    
    	    String json = gson.toJson(u1);
    	    System.out.println(json);
    	    RequestBuilder requestBuilder = MockMvcRequestBuilders
     				.post("/saveCustomerDetails/")
     				.accept(org.springframework.http.MediaType.APPLICATION_JSON).content(json)
     				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);
    	  
    	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
     		System.out.println("YYYYYYYYYYYY"+result.getResponse().getStatus());

		assertEquals(400, result.getResponse().getStatus());
    }
	
	@Test
	public void saveTest2() throws Exception
    {	
		 User u1 = new User();
    	 //u1.setUserName("ac.p3");
    	 u1.setFirstName("alex");
    	 u1.setLastName("Paul");
    	 u1.setEmail("a@gmail.com");
    	 u1.setPassword("123456789");
    	    Gson gson = new Gson();    
    	    String json = gson.toJson(u1);
    	    System.out.println(json);
    	    RequestBuilder requestBuilder = MockMvcRequestBuilders
     				.post("/saveCustomerDetails/")
     				.accept(org.springframework.http.MediaType.APPLICATION_JSON).content(json)
     				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);
    	  
    	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
     		System.out.println("YYYYYYYYYYYY"+result.getResponse().getStatus());
		assertEquals(400, result.getResponse().getStatus());
    }
	@Test
	public void saveTest3() throws Exception
    {	
		 User u1 = new User();
    	 u1.setUserName("ac.p3");
    	 u1.setFirstName("alex");
    	 u1.setLastName("Paul");
    	 u1.setEmail("a@gmail.com");
    	 u1.setPassword("12345678911");
    	    Gson gson = new Gson();    
    	    String json = gson.toJson(u1);
    	    System.out.println(json);
    	    RequestBuilder requestBuilder = MockMvcRequestBuilders
     				.post("/saveCustomerDetails/")
     				.accept(org.springframework.http.MediaType.APPLICATION_JSON).content(json)
     				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);
    	  
    	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
     		System.out.println("YYYYYYYYYYYY"+result.getResponse().getStatus());
		assertEquals(400, result.getResponse().getStatus());
    }
	
	@Test
	public void saveTest4() throws Exception
    {	
		 User u1 = new User();
    	 u1.setUserName(RandomStringUtils.randomAlphabetic(10));
    	 u1.setFirstName("alex");
    	 u1.setLastName("Paul");
    	 u1.setEmail("a@gmail.com");
    	 u1.setPassword("123456789");
    	    Gson gson = new Gson();    
    	    String json = gson.toJson(u1);
    	    System.out.println(json);
    	    RequestBuilder requestBuilder = MockMvcRequestBuilders
     				.post("/saveCustomerDetails/")
     				.accept(org.springframework.http.MediaType.APPLICATION_JSON).content(json)
     				.contentType(org.springframework.http.MediaType.APPLICATION_JSON);
    	  
    	    MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
    }
	
	
}