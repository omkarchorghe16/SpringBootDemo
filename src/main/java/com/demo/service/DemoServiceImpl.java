package com.demo.service;

import org.apache.tomcat.util.json.JSONParser;
import org.h2.util.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.boot.json.JsonParser;
import org.springframework.stereotype.Service;

import com.demo.entity.SampleData;
import com.fasterxml.jackson.databind.ObjectMapper;

//import org.h2.util.json.JSONObject;

import com.fasterxml.jackson.databind.util.JSONPObject;

import nonapi.io.github.classgraph.json.JSONDeserializer;
import nonapi.io.github.classgraph.json.JSONUtils;

@Service
public class DemoServiceImpl implements DemoService{

	@Override
	public void fetchData(SampleData str) {
		
		try {
			//JSONObject json =JsonParser.str;
				System.out.println("JSON obj"+str);
				// ObjectMapper mapper = new ObjectMapper();
				 //JsonParser parser = mapper.readValue(str.toString(), JsonParser.class);
				 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void fetchRawData(String str) {
		try {
			//JSONObject json =JsonParser.str;
				System.out.println("JSON string "+str);
				 ObjectMapper mapper = new ObjectMapper();
				JsonParser parser = mapper.readValue(str.toString(), JsonParser.class);
				System.out.println("parser ="+parser.toString());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
