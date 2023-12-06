package com.junit.mockito.business.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class AssertJAsserts {

	@Test
	public void hamcrestTests() {
		List<Integer> nums = Arrays.asList(10,20,34);
		
		assertThat(nums).hasSize(3)
						.contains(20)
						.allMatch(x -> x > 8)
						.allMatch(x -> x <40)
						.noneMatch(x -> x < 0);
		
		assertThat("TEXTME").hasSize(6)
							.startsWith("TE")
							.endsWith("ME")
							.contains("XT");
		
		
	}
}
