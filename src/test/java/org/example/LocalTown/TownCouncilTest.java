package org.example.LocalTown;

import org.example.VehicleType;
import org.example.exception.DuplicateUserID;
import org.example.exception.UserNotRegistered;
import org.example.vehicles.Car;
import org.example.vehicles.Vehicle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

class TownCouncilTest {
    Person requester = new Person("he245", "Rose");
    Person newRequester = new Person("he456", "Rose");
    Person owner1 = new Person("he123", "Gideon");
    Vehicle vehicle = new Car("et123", owner1, any(VehicleType.class));

    TownCouncil town = Mockito.mock(TownCouncil.class);


    @Test
    void isRegistered() throws DuplicateUserID {
//        Person requester = new Person("he245", "Rose");
//        Person newRequester = new Person("he456", "Rose");

//        Person owner1 = new Person("he123", "Gideon");
        Person owner2 = new Person("he245","Rose");

//        Vehicle vehicle = new Car("et123", owner1, any(VehicleType.class));
        vehicle.addNewOwner(owner2);

//        TownCouncil town = Mockito.mock(TownCouncil.class);
        boolean actual = town.isRegistered(requester, vehicle);

        boolean falseActual = town.isRegistered(newRequester, vehicle);

        assertEquals(true, actual);

        assertThrows(DuplicateUserID.class, () -> town.isRegistered(newRequester, vehicle) );


    }

    @Test
    void issuePermit() throws UserNotRegistered {
        Integer actualPermitNumber = town.issuePermit(requester, vehicle);
        assertEquals(1, actualPermitNumber);

        assertThrows(UserNotRegistered.class, () -> town.isRegistered(newRequester, vehicle) );

        assertDoesNotThrow(() -> (town.isRegistered(newRequester, vehicle))); //??correct or not??

    }
}