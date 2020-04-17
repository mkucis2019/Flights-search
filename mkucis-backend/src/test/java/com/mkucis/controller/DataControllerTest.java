package com.mkucis.controller;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import com.mkucis.app.ApplicationTests;
import com.mkucis.entity.Airport;
import com.mkucis.repository.AirportRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
public class DataControllerTest extends ApplicationTests {
	
	
    @Autowired
    private AirportRepository repository;
    
    
    @Test
    public void testDatabase() throws Exception {
    	
    	List<Airport> ar = repository.findAll();
    	
    	assertEquals(ar.size(), 6);
    	assertEquals(ar.get(0).getName(), "Logan International Airport");
        
    }
}
