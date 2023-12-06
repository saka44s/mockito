package com.junit.mockito.busniess.services;

import java.util.List;

import com.junit.mockito.business.Intrfc.SomeDataService;

public class SomeBusinessImpl {
	SomeDataService someDataService;

	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int sumThem(List<Integer> lst) {
		int val = 0;
		for(int var:lst) {
			val +=var;
		}
		return val;
	}
	
	public int sumThemFromDataService() {
		List<Integer> lst = someDataService.retrieveData();
		int val = 0;
		for(int var:lst) {
			val +=var;
		}
		return val;
	}
}
