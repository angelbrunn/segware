package com.segware.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.segware.bean.Posted;
import com.segware.bean.Posteds;
import com.segware.service.PostedService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	PostedService postService;

	private static final Integer ID = 10;

	Posted mockPosted;

	private static Posteds listPosted;

	@Test
	@Order(1)
	public void callGetAllPosteds() {
		listPosted = new Posteds();
		listPosted = postService.getAllPosteds();
		assertNotNull(listPosted);
	}

	@Test
	@Order(2)
	public void callSavePosted() {
		mockPosted = new Posted();
		mockPosted.setId(ID);
		mockPosted.setDescription("Test for Java, 'Barra Da Lagoa is my favorite site' ");
		mockPosted.setVotes(0);
		boolean result = postService.addPosted(mockPosted);
		assertEquals(true, result);
	}

	@Test
	@Order(3)
	public void callUpdatePosted() {
		mockPosted = new Posted();
		mockPosted.setId(ID);
		mockPosted.setDescription("Test for Java, 'I think Jurere is better' ");
		mockPosted.setVotes(0);
		boolean result = postService.updatePosted(mockPosted);
		assertEquals(true, result);
	}

	@Test
	@Order(4)
	public void callDeletePosted() {
		boolean result = postService.deleteOnePosted(ID);
		assertEquals(true, result);
	}

	@Test
	@Order(5)
	public void callDeleteAllPosted() {
		boolean result = postService.deleteAllPosted();
		assertEquals(true, result);
	}

}
