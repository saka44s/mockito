package com.junit.mockito.business.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

class JSONPathTest {

	@Test
	public void jsonPathTest() {
		String responseString = "["
				+"{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"value\":0}"
				+"{\"id\":2,\"name\":\"Pen\",\"price\":20,\"quantity\":100,\"value\":0}"
				+"{\"id\":3,\"name\":\"Eraser\",\"price\":5,\"quantity\":100,\"value\":0}"
				+"{\"id\":4,\"name\":\"Pencil\",\"price\":10,\"quantity\":100,\"value\":0}"
				+ "]";
		
		DocumentContext respParse = JsonPath.parse(responseString);
		
		int length = respParse.read("$.length()");
		
		assertThat(length).isEqualTo(4);
		
		
		List<Integer> idsList = respParse.read("$..id");
		assertThat(idsList).contains(4);
		assertThat(idsList).containsExactly(1,2,3,4);
		
		System.out.println(respParse.read("$.[1]").toString());
		System.out.println(respParse.read("$.[0:1]").toString());
		System.out.println(respParse.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println(respParse.read("$.[?(@.quantity=='100')]").toString());
		
		
		
	}
}
