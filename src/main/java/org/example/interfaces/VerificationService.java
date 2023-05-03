package org.example.interfaces;

import org.example.LocalTown.Person;
import org.example.vehicles.Vehicle;

public interface VerificationService{
    boolean verifyPerson(Person p, Vehicle v);
}