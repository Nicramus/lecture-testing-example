package com.globallogic.testing.car.api;

import org.springframework.stereotype.Service;

/**
 * Created by m on 22.05.18.
 */
@Service
public class CarService {
    public Car getCar(String manufacture, String model) {
        return new Car("", "");
    }
}
