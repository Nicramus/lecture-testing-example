package com.globallogic.testing.car;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.globallogic.testing.Application;

@RunWith(SpringRunner.class)
@WebMvcTest(Application.class)
public class ApplicationTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindCarByNameEndpoint() throws Exception {		
		
		mockMvc.perform(get("/homepage")).andDo(print())
				.andExpect(status().isOk());
	}

}
