package org.example.LocalTown;

import java.util.Objects;

public class Person {
    private String Id;
    private String name;

    public Person(String id, String name) {
        Id = id;
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Id.equals(person.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
