package application;

import domain.Person;
import infra.NationalArchivesMock;
import infra.ProspectQualificationMock;
import infra.RegistrySystemMock;
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
    public void prospectApprovedPerson_WithoutScore_WithSucess() throws InterruptedException, ExecutionException {
        Person person = new Person("128452",
                LocalDate.of(1985, 5, 3),
                "Mariana",
                "Vicentina");

        SalesQualifiedProspect service = new SalesQualifiedProspect(
                new RegistrySystemMock(person),
                new NationalArchivesMock(person),
                new ProspectQualificationMock(person, 60)
        );
        service.prospect();

        assertEquals("Not Approved!", outputStreamCaptor.toString().trim());
    }

    @Test
    public void prospectNotApprovedPerson_WithoutRegistry_WithSuccess() throws InterruptedException, ExecutionException {
        Person person = new Person("487545",
                LocalDate.of(1985, 5, 3),
                "José",
                "Patrício");

        SalesQualifiedProspect service = new SalesQualifiedProspect(
                new RegistrySystemMock(person),
                new NationalArchivesMock(person),
                new ProspectQualificationMock(person, 75)
        );
        service.prospect();

        assertEquals("Not Approved!", outputStreamCaptor.toString().trim());
    }

    @Test
    public void prospectNotApprovedPerson_WithinNationalArchives_WithSuccess() throws InterruptedException, ExecutionException {
        Person person = new Person("154678",
                LocalDate.of(2007, 3, 12),
                "Gilberto",
                "Emerson");

        SalesQualifiedProspect service = new SalesQualifiedProspect(
                new RegistrySystemMock(person),
                new NationalArchivesMock(person),
                new ProspectQualificationMock(person, 61)
        );
        service.prospect();

        assertEquals("Not Approved!", outputStreamCaptor.toString().trim());
    }
}
