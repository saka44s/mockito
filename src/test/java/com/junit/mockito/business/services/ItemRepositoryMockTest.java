package com.junit.mockito.business.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.junit.mockito.business.IData.ItemRepository;
import com.junit.mockito.test.dto.Item;

@DataJpaTest
class ItemRepositoryMockTest {
	
	@Autowired
	private ItemRepository itemRepository;

	@Test
	void testItemRepositoryFindAll() {
		List<Item> findAll = itemRepository.findAll();
		assertEquals(2, findAll.size());
	}

}
