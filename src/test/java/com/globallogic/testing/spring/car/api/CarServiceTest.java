package com.globallogic.testing.spring.car.api;

import static org.assertj.core.api.Assertions.*;

import com.globallogic.testing.car.api.model.Car;
import com.globallogic.testing.car.api.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Created by m on 21.05.18.
 */
//inicjacja mockito
//tożsame z MockitoAnnotations.initMocks();
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    //spring jako taki to szczegół implementacyjny
    //nie robimy tutaj autowired!
    //adnotacja Mock nie ma nic wspólnego z mechanizmem wstrzykiwania zależności springa!!
    @Mock
    private CarService carService;

    @Test
    public void testFindCarByName() {

        final String manufacture = "Batmobil";
        final String model = "105";
        Mockito.when(carService.getCar(manufacture, model)).thenReturn(new Car(manufacture, model));
        //Mockito.verifyNoMoreInteractions();
        //Mockito.verifyNoMoreInteractions();
        //verify mozemy sprawdzic "interakcje" z naszym mockiem
        assertThat(carService.getCar(manufacture, model)).isEqualTo(new Car(manufacture, model));
        
    }
}
