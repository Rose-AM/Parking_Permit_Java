package org.example.vehicles;

import org.example.VehicleType;
import org.example.exception.DuplicateUserID;
import org.example.LocalTown.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)

class CarTest {
    Person owner = Mockito.mock(Person.class);


    @Test
    void TestCarChargePerMonth() throws DuplicateUserID {
        Person owner = new Person("he123", "Rose");
        Vehicle car = new Car("he123", owner, VehicleType.CAR);

        double actual = car.getChargePerMonth();

        assertEquals(20, actual);
    }

    @Test
    void testAddingNewUserToCar() throws DuplicateUserID {
        Person owner = new Person("he123", "Rose");

        Vehicle car = new Car("he123", owner, VehicleType.CAR);

        Person owner1 = new Person ("he456", "Gideon");
        car.addNewOwner(owner1);
        double actual = car.getChargePerMonth();

        assertEquals(40, actual);
    }

    @Test
    void getVehicleTypeTest(){
        Vehicle car = new Car("he123", owner, VehicleType.CAR);
        VehicleType actual = car.getVehicleType();
        assertEquals("CAR",actual.toString());


    }

    @Test
    void exceptionTesting() {
        Person owner = new Person("he123", "Rose");
        Person owner1 = new Person ("he123", "Gideon");

        Vehicle car = new Car("he123", owner, VehicleType.CAR);

        DuplicateUserID thrown = assertThrows(DuplicateUserID.class, () -> car.addNewOwner(owner1));


    }


}