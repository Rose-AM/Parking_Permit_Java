package org.example.vehicles;

import org.example.VehicleType;
import org.example.LocalTown.Person;

public class Car extends Vehicle {
    final double charge = 20.0;


    public Car(String numberPlate, Person owner) {
        super(numberPlate, owner, VehicleType.CAR);
    }

    @Override
    public double getChargePerMonth() {
        int numOfOwners = getOwners().size();
        return charge * numOfOwners;
    }
}
