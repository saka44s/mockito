package com.junit.mockito.business.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class HamcrestAsserts {

	@Test
	public void hamcrestTests() {
		List<Integer> nums = Arrays.asList(10,20,34);
		
		assertThat(nums, hasSize(3));
		assertThat(nums, hasItems(20,34));
		assertThat(nums, everyItem(greaterThan(8)));
		assertThat(nums, everyItem(lessThan(40)));
		
		assertThat("", isEmptyString());
		assertThat("TEXTME", startsWith("TE"));
		assertThat("TEXTME", endsWith("ME"));
	}

}
