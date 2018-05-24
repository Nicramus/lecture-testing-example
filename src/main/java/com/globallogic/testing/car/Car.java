package com.globallogic.testing.car;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by m on 21.05.18.
 */
public class Car implements Serializable {
	
	private String manufacture;
	private String model;
	
	public Car() {
		
	}
	
    public Car(String manufacture, String model) {
    	this.setManufacture(manufacture);
    	this.setModel(model);
    }

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this.manufacture, this.model);
	}
    
	@Override
	public boolean equals(Object object) {
		return EqualsBuilder.reflectionEquals(object, this);
	}
}
