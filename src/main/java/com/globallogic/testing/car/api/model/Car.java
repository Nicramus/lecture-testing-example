package com.globallogic.testing.car.api.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Objects;

/**
 * Created by m on 21.05.18.
 */
public class Car {

    private String manufacture;
    private String model;

    public Car(String manufacture, String model) {
        this.manufacture = manufacture;
        this.model = model;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder.reflectionHashCode(this.manufacture, this.model);
        return Objects.hash(this.manufacture, this.model);
    }

    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }
}
