package domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void shouldCreatePerson_WithSuccess() {
        Person person = new Person("124875", LocalDate.of(2010, 3, 7), "Jean", "Dobre");

        assertEquals("Jean Dobre", person.fullName());
        assertEquals("07/03/2010", person.birthDate());
        assertEquals("124875", person.nationalIdNumber());

    }
}
