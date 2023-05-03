package org.example.vehicles;

import org.example.VehicleType;
import org.example.LocalTown.Person;

public class Motorbike extends Vehicle {
    final double capacity;
    final double chargePerMonth;

    public Motorbike(String numberPlate, Person owner, double capacity) {
        super(numberPlate, owner, VehicleType.MOTORBIKE);
        this.capacity = capacity;
        chargePerMonth = capacity > 850 ? 10 : 7;
    }


    @Override
    public double getChargePerMonth() {
        return chargePerMonth;
    }
}
