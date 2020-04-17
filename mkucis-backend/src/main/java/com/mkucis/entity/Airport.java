package com.mkucis.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.NonNull;

@Entity
public class Airport {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    private Long id;
    
    @NonNull
    private  String name;
    
    @NonNull @Column(length = 3, unique = true)
    private  String iataCode;
    
    public Long getId() {
    	return this.id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getIataCode() {
    	return this.iataCode;
    }
    
    public void setIataCode(String iataCode) {
    	this.iataCode = iataCode;
    }
}
