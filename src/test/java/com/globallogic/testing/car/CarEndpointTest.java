package com.globallogic.testing.car;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
//Do testów możemy wstrzyknąć własną konfigurację
@SpringBootTest
@AutoConfigureMockMvc
public class CarEndpointTest {
	//testy integracyjne ciężkie i lekkie
	//ten podział względny - wszystko zależy jak długo program wstaje !
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CarService carService;

	@Test
	public void testFindCarByNameEndpoint() throws Exception {

		final String FIND_CAR_BY_NAME_GET_ENDPOINT = "/vehiclesshop/v1/cars/findcarbyname";
		final String manufacture = "Batmobil";
		final String model = "105";		
		when(carService.getCar(manufacture, model)).thenReturn(new com.globallogic.testing.car.Car(manufacture, model));		
		
		mockMvc.perform(get(FIND_CAR_BY_NAME_GET_ENDPOINT)
				.param("manufacture", manufacture)
				.param("model", model)				
				.accept(MediaType.APPLICATION_JSON_VALUE)
		).andDo(print())
				.andExpect(status().isOk());
	}
	
	@Test
	public void testNonExisitingManufacture() throws Exception {

		final String FIND_CAR_BY_NAME_GET_ENDPOINT = "/vehiclesshop/v1/cars/findcarbyname";
		final String manufacture = "FSO";
		final String model = "105";		
		
		mockMvc.perform(get(FIND_CAR_BY_NAME_GET_ENDPOINT)
				.param("manufacture", manufacture)
				.param("model", model)				
				.accept(MediaType.APPLICATION_JSON_VALUE)
		).andDo(print())
				.andExpect(status().isBadRequest());
	}
	
}
