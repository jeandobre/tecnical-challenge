package application;

import domain.Person;
import infra.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.concurrent.ExecutionException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalesQualifiedProspectTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void prospectApprovedPerson_WithSucess() throws InterruptedException, ExecutionException {
        Person person = new Person("128452",
                LocalDate.of(1985, 5, 3),
                "Mariana",
                "Vicentina");

        SalesQualifiedProspect service = new SalesQualifiedProspect(
                new RegistrySystemMock(person),
                new NationalArchivesMock(person),
                new ProspectQualificationMock(person, 75)
        );
        service.prospect();

        assertEquals("Approved!", outputStreamCaptor.toString().trim());
    }

    @Test
    public void prospectNotApprovedPerson_WithSuccess() throws InterruptedException, ExecutionException {
        Person person = new Person(
                "123456",
                LocalDate.of(2010, 3, 7),
                "Jean",
                "Dobre");

        SalesQualifiedProspect service = new SalesQualifiedProspect(
                new RegistrySystemMock(person),
                new NationalArchivesMock(person),
                new ProspectQualificationMock(person, 75)
        );
        service.prospect();

        assertEquals("Not Approved!", outputStreamCaptor.toString().trim());
    }
}
