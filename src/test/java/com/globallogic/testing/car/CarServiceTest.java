package com.globallogic.testing.car;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.globallogic.testing.car.Car;
import com.globallogic.testing.car.CarService;

/**
 * Created by m on 21.05.18.
 */
@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Test
    public void testFindCarByName() {
        CarService cs = new CarService();
        final String manufacture = "Batmobil";
        final String model = "105";
        Mockito.when(cs.getCar(manufacture, model)).thenReturn(new Car(manufacture, model));
        assertThat(cs.getCar(manufacture, model)).isEqualTo(new Car(manufacture, model));
    }
}
