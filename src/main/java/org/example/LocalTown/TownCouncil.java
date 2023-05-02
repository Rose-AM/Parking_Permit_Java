package org.example.LocalTown;

import org.example.exception.UserNotRegistered;
import org.example.vehicles.Vehicle;
import org.example.VehicleType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TownCouncil {

    private static int vehiclePermitNumber;
    private Map<VehicleType, Integer> vehicleTypeCount = new HashMap<>();
    private static int totalNumberOfVehiclesWithPermit;

    public boolean isRegistered(Person requester, Vehicle vehicle) {
        List<Person> registeredPersons = vehicle.getOwners();
        return registeredPersons.contains(requester);
    }

    public Integer issuePermit(Person requester, Vehicle vehicle) throws UserNotRegistered {
        if (isRegistered(requester, vehicle)) {
            vehiclePermitNumber++;

            //method to get the vehicle type (as param) and use as key
            updateVehicleTypesWithPermit(vehicle.getVehicleType());
            totalNumberOfVehiclesWithPermit++;

            return vehiclePermitNumber;
        }
        throw new UserNotRegistered("Not a registered user of this vehicle");
    }

    private void updateVehicleTypesWithPermit(VehicleType vehicleType) {
        Integer updatedCount = vehicleTypeCount.getOrDefault(vehicleType, 0) + 1;
        vehicleTypeCount.put(vehicleType, updatedCount);
    }
}
