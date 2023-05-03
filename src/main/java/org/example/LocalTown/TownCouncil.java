package org.example.LocalTown;

import org.example.exception.UserNotRegisteredException;
import org.example.interfaces.PermitIssuerService;
import org.example.interfaces.VerificationService;
import org.example.vehicles.Vehicle;
import org.example.VehicleType;

import java.util.HashMap;
import java.util.Map;

public class TownCouncil {

    private Integer vehiclePermitNumber;
    private final Map<VehicleType, Integer> vehicleTypeCount;
    private static int totalNumberOfVehiclesWithPermit;

    VerificationService verificationServiceObject;
    PermitIssuerService permitIssuerServiceObject;

    public TownCouncil (VerificationService verificationServiceObject, PermitIssuerService permitIssuerServiceObject){
        this.verificationServiceObject = verificationServiceObject;
        this.permitIssuerServiceObject = permitIssuerServiceObject;
        vehiclePermitNumber = 0;
        vehicleTypeCount = new HashMap<>();
    }

    public String issuePermit(Person requester, Vehicle vehicle) throws UserNotRegisteredException {
        if (verificationServiceObject.verifyPerson(requester, vehicle)) {
            if (vehicle.getVehicleType().equals(VehicleType.CAR)
                    || vehicle.getVehicleType().equals(VehicleType.MOTORBIKE)) {

                return permitIssuerServiceObject.issuePermit(vehicle);
            }
            else {
                vehiclePermitNumber++;
                String permitNumber = "ET" +  Integer.toString(vehiclePermitNumber);
                updateVehicleTypesWithPermit(vehicle.getVehicleType());
                return permitNumber;
            }
        }
        throw new UserNotRegisteredException("Not registered to this vehicle");
    }


    private void updateVehicleTypesWithPermit(VehicleType vehicleType ) {
        Integer updatedCount = vehicleTypeCount.getOrDefault(vehicleType, 0) + 1;
        vehicleTypeCount.put(vehicleType, updatedCount);
    }

}
