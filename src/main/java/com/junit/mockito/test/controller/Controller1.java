package com.junit.mockito.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.junit.mockito.busniess.services.ItemService;
import com.junit.mockito.test.dto.Item;


@RestController
public class Controller1 {
	
	@Autowired
	private ItemService itemService;
	
	@GetMapping("/getItem")
	public Item dummyItems() {
		return new Item(1, "Ball", 10, 100);
	}
	
	@GetMapping("/getItemFromService")
	public Item itemsFromService() {
		return itemService.getItems();
	}
	
	@GetMapping("/getAllItems")
	public List<Item> allItemsFromService() {
		return itemService.getAllItems();
	}
}
