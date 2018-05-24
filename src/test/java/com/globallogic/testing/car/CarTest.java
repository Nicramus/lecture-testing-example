package com.globallogic.testing.car;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarTest {
	
	@Test
	public void testEquals() {
		Car car1 = new Car("A", "B");
		Car car2 = new Car("A", "B");
		assertTrue(car1.equals(car2));
	}
	
	@Test
	public void notEquals() {
		Car car1 = new Car("A", "B");
		Car car2 = new Car("A", "C");
		assertFalse(car1.equals(car2));
	}
}
