package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.entity.SampleData;

@Service
public interface DemoService {

	public void fetchData(SampleData str);

	public void fetchRawData(String str);
}
