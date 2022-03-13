package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Person {

    private String nationalIdNumber;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String email;

    public Person(String nationalIdNumber, LocalDate birthDate, String firstName, String lastName) {
        this.nationalIdNumber = nationalIdNumber;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String fullName() {
        return this.firstName + " " + this.lastName;
    }

    public String nationalIdNumber() {
        return this.nationalIdNumber;
    }

    public String birthDate() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return birthDate.format(pattern);
    }

    public String email() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(nationalIdNumber, person.nationalIdNumber) && Objects.equals(birthDate, person.birthDate) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationalIdNumber, birthDate, firstName, lastName);
    }

    @Override
    public String toString() {
        return this.nationalIdNumber() + " - " + this.fullName();
    }
}
