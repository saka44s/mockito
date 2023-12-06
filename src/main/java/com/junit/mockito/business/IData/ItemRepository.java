package com.junit.mockito.business.IData;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junit.mockito.test.dto.Item;

public interface ItemRepository extends JpaRepository<Item,Integer> {

}
