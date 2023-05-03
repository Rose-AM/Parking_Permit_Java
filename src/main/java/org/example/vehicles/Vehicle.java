package org.example.vehicles;

import org.example.exception.DuplicateUserIDException;
import org.example.LocalTown.Person;
import org.example.VehicleType;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    private String numberPlate;
    private double chargePerMonth;
    private VehicleType vehicleType;
    private List<Person> owners = new ArrayList<>() ;


// constructor
    public Vehicle(String numberPlate, Person owner, VehicleType vehicleType) {
        this.numberPlate = numberPlate;
        this.vehicleType = vehicleType;
        owners.add(owner);
    }

    public abstract double getChargePerMonth();

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    //add new owner to the vehicle
    public void addNewOwner(Person newOwner) throws DuplicateUserIDException {
        for (Person owner : owners) {
            if (owner.equals(newOwner) ) {
                throw new DuplicateUserIDException("User ID already exists");
            }
        }
            owners.add(newOwner);
    }

    //get all owners for that particular vehicle
    public List<Person> getOwners() {
        return owners;
    }




}
