package com.globallogic.testing.car;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

/**
 * Created by m on 22.05.18.
 */
@Service
public class CarService {
	
	private List<Car> list = new ArrayList<>();
	
	@PostConstruct
	private void initMap() {
		list.add(new Car("Batmobil", "105"));
		list.add(new Car("Ferrari", "Testarossa"));
		list.add(new Car("Fiat", "126p"));
		list.add(new Car("Mercedes", "W230"));		
	}
	
    public Car getCar(String manufacture, String model) {
    	for(Car car : list) {
    		if (car.getManufacture().equals(manufacture) && car.getModel().equals(model)) {
    			return car;
    		}
    	}
    	return new Car();
    }
}
