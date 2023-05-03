package org.example.vehicles;

import org.example.VehicleType;
import org.example.exception.DuplicateUserIDException;
import org.example.LocalTown.Person;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)

class CarTest {
    Person owner = Mockito.mock(Person.class);


    @Test
    void TestCarChargePerMonth(){
        Person owner = new Person("he123", "Rose");
        Vehicle car = new Car("et123", owner);

        double actual = car.getChargePerMonth();

        assertEquals(20, actual);


        assertThrows(DuplicateUserIDException.class, ()-> car.addNewOwner(new Person("he123", "rose")));
    }

    @Test
    void testAddingNewUserToCar() throws DuplicateUserIDException {
        Person owner = new Person("he123", "Rose");

        Vehicle car = new Car("he123", owner);

        Person owner1 = new Person ("he456", "Gideon");
        car.addNewOwner(owner1);
        double actual = car.getChargePerMonth();

        assertEquals(40, actual);
    }

    @Test
    void getVehicleTypeTest(){
        Vehicle car = new Car("he123", owner);
        VehicleType actual = car.getVehicleType();
        assertEquals("CAR",actual.toString());


    }

    @Test
    void exceptionTesting() {
        Person owner = new Person("he123", "Rose");
        Person owner1 = new Person ("he123", "Gideon");

        Vehicle car = new Car("he123", owner);

        assertThrows(DuplicateUserIDException.class, () -> car.addNewOwner(owner1));

        assertDoesNotThrow(() -> car.addNewOwner(owner1));


    }


}