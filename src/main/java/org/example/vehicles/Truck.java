package org.example.vehicles;

import org.example.VehicleType;
import org.example.LocalTown.Person;

public class Truck extends Vehicle {
    final double capacity;
    final double baseCapacity = 150;
    final double chargePerMonth = 30.00;
    final double chargePer20kg = 5.0;


    public Truck(String numberPlate, Person owner, VehicleType vehicleType, double capacity) {
        super(numberPlate, owner, vehicleType);
        this.capacity = capacity;
    }

    @Override
    public double getChargePerMonth() {
             double extraCapacity = capacity - baseCapacity;
             int multiplier = extraCapacity > 0 ? (int) Math.ceil(extraCapacity/20) : 0;
             double extraCharge = chargePer20kg * multiplier;
             return chargePerMonth + extraCharge;
    }
}
