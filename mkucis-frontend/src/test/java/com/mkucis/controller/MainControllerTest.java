package com.mkucis.controller;



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
import com.mkucis.controller.MainController;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=MainController.class)
public class MainControllerTest extends ApplicationTest {
 
	@Autowired
	private WebApplicationContext webApplicationContext;
	
    @Autowired
    private MockMvc mvc;
    
    @Before
    public void setup() throws Exception {
    	mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    public void indexPageTest()
      throws Exception {
    	
    mvc.perform(get("/")
    	      .contentType(MediaType.TEXT_HTML))
    		  .andDo(print())
    	      .andExpect(status().isOk())
    		  .andExpect(forwardedUrl("index"));
    }
    
    @Test
    public void adminPageTest()
      throws Exception {
    	
    mvc.perform(get("/admin")
    	      .contentType(MediaType.TEXT_HTML))
    		  .andDo(print())
    	      .andExpect(status().isOk())
    		  .andExpect(forwardedUrl("administration"));
    }
}
