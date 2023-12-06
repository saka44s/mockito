package com.junit.mockito.business.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.junit.mockito.business.Intrfc.SomeDataService;
import com.junit.mockito.busniess.services.SomeBusinessImpl;


class SomeBusinessMockitoTest {

	@Test
	void calcSumByDataServiceImpl_basic() {
		
		SomeBusinessImpl impl = new SomeBusinessImpl();
		
		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveData()).thenReturn(Arrays.asList(1,2,3,4));
		
		impl.setSomeDataService(dataServiceMock);
		int actualResult = impl.sumThemFromDataService();
		assertEquals(actualResult, 10);
	}
	
	@Test
	void calcSumByDataServiceImpl_empty() {
		SomeBusinessImpl impl = new SomeBusinessImpl();

		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveData()).thenReturn(Arrays.asList());
		
		impl.setSomeDataService(dataServiceMock);
		
		int actualResult = impl.sumThemFromDataService();
		assertEquals(actualResult, 0);
	}
	
	@Test
	void calcSumByDataServiceImpl_single() {
		SomeBusinessImpl impl = new SomeBusinessImpl();

		SomeDataService dataServiceMock = mock(SomeDataService.class);
		when(dataServiceMock.retrieveData()).thenReturn(Arrays.asList(1));
		
		impl.setSomeDataService(dataServiceMock);
		
		int actualResult = impl.sumThemFromDataService();
		assertEquals(actualResult, 1);
	}

}
