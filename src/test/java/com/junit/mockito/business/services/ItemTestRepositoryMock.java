package com.junit.mockito.business.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.junit.mockito.business.IData.ItemRepository;
import com.junit.mockito.busniess.services.ItemService;
import com.junit.mockito.test.dto.Item;

@ExtendWith(MockitoExtension.class)
class ItemTestRepositoryMock {
	
	@InjectMocks
	ItemService itemService;
	
	@Mock
	ItemRepository itemRepository;
	
	
	@Test
	void calcSumByDataServiceImpl_basic() {
		when(itemService.getAllItems()).thenReturn(Arrays.asList(new Item(1,"Item1",10,10),new Item(2,"Item2",20,20)));
		
		assertEquals(100, itemService.getAllItems().get(0).getValue());
	}

}
