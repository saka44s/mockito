package com.junit.mockito.business.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.junit.mockito.busniess.services.SomeBusinessImpl;

class SomeBusinessTest {

	@Test
	void calcSum_basic() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		List<Integer> intList = Arrays.asList(1,2,3,4);
		int actualResult = impl.sumThem(intList);
		assertEquals(actualResult, 10);
	}
	
	@Test
	void calcSum_empty() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		List<Integer> intList = Arrays.asList();
		int actualResult = impl.sumThem(intList);
		assertEquals(actualResult, 0);
	}
	
	@Test
	void calcSum_single() {
		SomeBusinessImpl impl = new SomeBusinessImpl();
		List<Integer> intList = Arrays.asList(1);
		int actualResult = impl.sumThem(intList);
		assertEquals(actualResult, 1);
	}

}
