package org.example.vehicles;

import org.example.LocalTown.Person;
import org.example.VehicleType;
//import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TruckTest {

    @Test
    void testChargeForTruck(){
        Person owner = Mockito.mock(Person.class);
        Vehicle truck = new Truck("et1", owner, 170);
        double actual = truck.getChargePerMonth();

        assertEquals(35.0, actual);

    }

}