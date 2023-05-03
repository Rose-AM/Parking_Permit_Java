package org.example.vehicles;

import org.example.LocalTown.Person;
import org.example.VehicleType;
import org.example.vehicles.Motorbike;
import org.example.vehicles.Vehicle;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class MotorbikeTest {
    Person owner = Mockito.mock(Person.class);

    @Test
    void testGetChargePerMonth() {

        Vehicle motorbike = new Motorbike("he1", this.owner, 900);
        double actual = motorbike.getChargePerMonth();

        assertEquals(10, actual );
    }
}