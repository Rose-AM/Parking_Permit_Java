package org.example.vehicles;

import org.example.VehicleType;
import org.example.LocalTown.Person;

public class Motorbike extends Vehicle {
    final double capacity;
    final double chargePerMonth;

    public Motorbike(String numberPlate, Person owner, VehicleType vehicleType, double capacity) {
        super(numberPlate, owner, vehicleType);
        this.capacity = capacity;
        chargePerMonth = capacity > 850 ? 10 : 7;
    }


    @Override
    public double getChargePerMonth() {
        return chargePerMonth;
    }
}
