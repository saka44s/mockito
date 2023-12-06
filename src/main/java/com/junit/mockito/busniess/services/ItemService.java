package com.junit.mockito.busniess.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.junit.mockito.business.IData.ItemRepository;
import com.junit.mockito.test.dto.Item;

@Component
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	public Item getItems() {
		return new Item(1, "Ball", 10, 100);
	}
	
	
	public List<Item> getAllItems(){
		//return itemRepository.findAll();
		List<Item> items = itemRepository.findAll();
		
		/*
		 * for(Item item: items) { item.setValue(item.getPrice()*item.getQuantity()); }
		 */
		items.forEach(i -> i.setValue(i.getPrice()*i.getQuantity()));
		return items;
	}

}
