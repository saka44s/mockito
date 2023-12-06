package com.junit.mockito.business.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.junit.mockito.business.Intrfc.SomeDataService;
import com.junit.mockito.busniess.services.SomeBusinessImpl;

@ExtendWith(MockitoExtension.class)
class SomeBusinessMockitoTest3 {
	
	@InjectMocks
	SomeBusinessImpl impl;
	
	@Mock
	SomeDataService dataServiceMock;
	
	
	@Test
	void calcSumByDataServiceImpl_basic() {
		when(dataServiceMock.retrieveData()).thenReturn(Arrays.asList(1,2,3,4));
		
		assertEquals(10, impl.sumThemFromDataService());
	}
	
	@Test
	void calcSumByDataServiceImpl_empty() {
		when(dataServiceMock.retrieveData()).thenReturn(Arrays.asList());

		assertEquals(0, impl.sumThemFromDataService());
	}
	
	@Test
	void calcSumByDataServiceImpl_single() {
		when(dataServiceMock.retrieveData()).thenReturn(Arrays.asList(1));

		assertEquals(1, impl.sumThemFromDataService());
	}

}
