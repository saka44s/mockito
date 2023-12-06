package com.junit.mockito.business.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.junit.mockito.business.Intrfc.SomeDataService;
import com.junit.mockito.busniess.services.SomeBusinessImpl;

class SomeDataServiceStubImpl implements SomeDataService{

	@Override
	public List<Integer> retrieveData() {
		List<Integer> intList = Arrays.asList(1,2,3,4);
		return intList;
	}
	
}

class SomeDataServiceEmptyStubImpl implements SomeDataService{

	@Override
	public List<Integer> retrieveData() {
		List<Integer> intList = Arrays.asList();
		return intList;
	}
	
}

class SomeDataServiceOneStubImpl implements SomeDataService{

	@Override
	public List<Integer> retrieveData() {
		List<Integer> intList = Arrays.asList(1);
		return intList;
	}
	
}

class SomeBusinessStubTest {

	@Test
	void calcSumByDataServiceImpl_basic() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		impl.setSomeDataService(new SomeDataServiceStubImpl());
		int actualResult = impl.sumThemFromDataService();
		assertEquals(actualResult, 10);
	}
	
	@Test
	void calcSumByDataServiceImpl_empty() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		impl.setSomeDataService(new SomeDataServiceEmptyStubImpl());
		int actualResult = impl.sumThemFromDataService();
		assertEquals(actualResult, 0);
	}
	
	@Test
	void calcSumByDataServiceImpl_single() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		impl.setSomeDataService(new SomeDataServiceOneStubImpl());
		int actualResult = impl.sumThemFromDataService();
		assertEquals(actualResult, 1);
	}

}
