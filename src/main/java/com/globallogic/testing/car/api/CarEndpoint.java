package com.globallogic.testing.car.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by m on 21.05.18.
 */
@RestController
@RequestMapping("/vehiclesshop/v1/cars")
public class CarEndpoint {

    @Autowired
    private CarService carService;

    @GetMapping(path = "/findcarbyname", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Object> getCarByName(@RequestParam String manufacture, @RequestParam String model) {
        return  ResponseEntity.ok().body(carService.getCar(manufacture, model));
    }

}
