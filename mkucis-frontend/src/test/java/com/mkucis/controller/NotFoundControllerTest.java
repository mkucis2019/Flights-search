package com.mkucis.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.mkucis.app.ApplicationTest;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=NotFoundController.class)
public class NotFoundControllerTest extends ApplicationTest {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
    @Autowired
    private MockMvc mvc;
    
    @Autowired
    private NotFoundController ctrl;
    
    @Before
    public void setup() throws Exception {
    	mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void errorPageTest() throws Exception {
    	
    mvc.perform(get("/error")
    	      .contentType(MediaType.TEXT_HTML))
    		  .andDo(print())
    	      .andExpect(status().isOk())
    		  .andExpect(forwardedUrl("error_msg"));
    }
    
    @Test
    public void getErrorPathTest() throws Exception {
    	assertEquals(ctrl.getErrorPath(), "/error");
    }
}
