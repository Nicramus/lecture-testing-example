package com.globallogic.testing.car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by m on 21.05.18.
 */
@RestController
public class CarEndpoint {

    @Autowired
    private CarService carService;
    
    	@RequestMapping(
    			path = "/vehiclesshop/v1/cars/findcarbyname",
    			method = RequestMethod.GET,
    			produces = MediaType.APPLICATION_JSON_VALUE)
    	public Car getCarByName(@RequestParam(name = "manufacture") String manufacture, 
    							@RequestParam(name = "model") String model) {
    		return  carService.getCar(manufacture, model);
    }
    

    
    

}
