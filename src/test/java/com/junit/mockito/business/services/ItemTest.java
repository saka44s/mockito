package com.junit.mockito.business.services;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.junit.mockito.busniess.services.ItemService;
import com.junit.mockito.test.controller.Controller1;
import com.junit.mockito.test.dto.Item;


@ExtendWith(MockitoExtension.class)
@WebMvcTest(Controller1.class)
class ItemTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private ItemService itemService;

	@Test
	public void dummyItemtest_basic() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItem").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		//.andExpect(content().toString())
		.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
		.andReturn();
	}
	
	@Test
	public void getItemFromService_basic() throws Exception {
		
		when(itemService.getItems()).thenReturn(new Item(1,"Ball",10,100));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getItemFromService").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder)
		.andExpect(status().isOk())
		//.andExpect(content().toString())
		.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
		.andReturn();
	}

}
