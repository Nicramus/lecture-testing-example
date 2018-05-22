package com.globallogic.testing.spring.car.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//Do testów możemy wstrzyknąć własną konfigurację
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
		classes = CarEndpointTest.LocalTestConfiguration.class)
public class CarEndpointTest {
	//testy integracyjne ciężkie i lekkie
	//ten podział względny - wszystko zależy jak długo program wstaje !

	private MockMvc mockMvc;

	@Test
	public void testFindCarByNameEndpoint() throws Exception {
		final String FIND_CAR_BY_NAME_GET_ENDPOINT = "vehiclesshop/v1/cars/findcarbyname";
		final String manufacuture = "Batmobil";
		final String model = "105";

		mockMvc.perform(get(FIND_CAR_BY_NAME_GET_ENDPOINT)
				.param("firstName", manufacuture)
				.param("lastName", model)
		).andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"));
//				.andExpect(jsonPath("$[0].id").exists())
//				.andExpect(jsonPath("$[0].fn").value("Marge"));


	}

	@Configuration
	static class LocalTestConfiguration {
		@Bean
		ServletWebServerFactory servletWebServerFactory(){
			return new TomcatServletWebServerFactory();
		}
	}

}
