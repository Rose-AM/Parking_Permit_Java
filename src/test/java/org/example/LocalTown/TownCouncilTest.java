package org.example.LocalTown;

import org.example.VehicleType;
import org.example.exception.UserNotRegisteredException;
import org.example.interfaces.PermitIssuerService;
import org.example.interfaces.VerificationService;
import org.example.vehicles.Car;
import org.example.vehicles.Motorbike;
import org.example.vehicles.Truck;
import org.example.vehicles.Vehicle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TownCouncilTest {

    TownCouncil underTest;
    Person unregisteredOwner;
    Person owner;
    Vehicle vehicle;

    @Mock
    Vehicle car = Mockito.mock(Car.class);

    @Mock
    VerificationService mockVerificationService;

    @Mock
    PermitIssuerService mockPermitIssuerService;

    @BeforeEach
    void setup(){
        owner = new Person("he123", "Rose");
        underTest = new TownCouncil(mockVerificationService, mockPermitIssuerService);
    }

  @Test
    void testVerificationServiceThrowsAnExceptionIfFalse(){
        vehicle = new Car("E11", owner);
        Mockito.when(mockVerificationService.verifyPerson(owner, vehicle )).thenReturn(Boolean.FALSE);
        Assertions.assertThrows(UserNotRegisteredException.class, () -> underTest.issuePermit(owner, vehicle));
  }

  @Test
  void testVerificationServiceDoesNotThrowAnExceptionIfTrue() throws UserNotRegisteredException {
      vehicle = new Car("E11", owner);
      Mockito.when(mockVerificationService.verifyPerson(owner, vehicle )).thenReturn(Boolean.TRUE);

      Assertions.assertDoesNotThrow(() -> underTest.issuePermit(owner, vehicle));
  }

  @Test
    void testThatPermitIssueServiceRunsWhenVehicleTypeIsACar() throws UserNotRegisteredException {
        //setup
      vehicle = new Car("12", owner);
      Mockito.when(mockVerificationService.verifyPerson(owner, vehicle)).thenReturn(Boolean.TRUE);
      Mockito.when(mockPermitIssuerService.issuePermit(vehicle)).thenReturn("ju");

      //action
      String actual = underTest.issuePermit(owner, vehicle);

      //assert
      Assertions.assertEquals("ju", actual);
      Mockito.verify(mockPermitIssuerService,Mockito.times(1)).issuePermit(vehicle);
  }

  @Test
    void testPermitIssueReturnsAndRunsWhenVehicleIsMotorBike() throws UserNotRegisteredException {

        //assign
        vehicle = new Motorbike("et12", owner, 150);
        Mockito.when(mockVerificationService.verifyPerson(owner, vehicle)).thenReturn(Boolean.TRUE);
        Mockito.when(mockPermitIssuerService.issuePermit(vehicle)).thenReturn("permit");

        //action
      //do the action and store what it returns to 'actual' variable
      String actual = underTest.issuePermit(owner, vehicle);

      //assert
      Assertions.assertEquals("permit", actual);
      Mockito.verify(mockPermitIssuerService, Mockito.times(1)).issuePermit(vehicle);
  }

    @Test
    void testReturnsValueWhenVehicleIsNeitherCarNorMotorbike() throws UserNotRegisteredException {
        vehicle = new Truck("he55", owner, 1234);
        Mockito.when(mockVerificationService.verifyPerson(owner, vehicle)).thenReturn(Boolean.TRUE);

        //action
        String actual = underTest.issuePermit(owner, vehicle);

        //assert or check
        Assertions.assertEquals("ET1",actual);

    }

    @Test
    void testThatUserNotRegisteredExpressionIsThrownWhenVerificationIsFalse() throws UserNotRegisteredException {
        // setup
        vehicle = new Car("et12", owner);
        Mockito.when(mockVerificationService.verifyPerson(owner, vehicle)).thenReturn(Boolean.FALSE);

        //action and assert throws an exception
        Assertions.assertThrows(UserNotRegisteredException.class, () ->underTest.issuePermit(owner, vehicle));

    }
}