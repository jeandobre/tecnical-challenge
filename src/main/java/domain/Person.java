package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
    public String toString() {
        return this.nationalIdNumber() + " - " + this.fullName();
    }
}
