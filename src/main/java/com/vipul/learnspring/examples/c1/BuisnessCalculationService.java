package com.vipul.learnspring.examples.c1;

import java.util.Arrays;

import org.springframework.stereotype.Service;

//@Component
@Service
public class BuisnessCalculationService {
	
	private DataService dataService;
	
	public BuisnessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

}
