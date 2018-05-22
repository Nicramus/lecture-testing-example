package com.globallogic.testing.spring.car.api;

import static org.assertj.core.api.Assertions.*;

import com.globallogic.testing.car.api.Car;
import com.globallogic.testing.car.api.CarService;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by m on 21.05.18.
 */
public class CarServiceTest {


    @Test
    public void testFindCarByName() {
        CarService cs = new CarService();
        final String manufacture = "Batmobil";
        final String model = "105";
        Mockito.when(cs.getCar(manufacture, model)).thenReturn(new Car(manufacture, model));
        //Mockito.verifyNoMoreInteractions();
        //Mockito.verifyNoMoreInteractions();
        assertThat(cs.getCar(manufacture, model)).isEqualTo(new Car(manufacture, model));
    }
}
