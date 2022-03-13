package infra;

import domain.Person;
import domain.RegistrySystem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class RegistrySystemMock extends RegistrySystem {

    private final List<Person> persons ;

    public RegistrySystemMock(Person person) {
        super(person);
        this.persons = new ArrayList<>(5);
        this.persons.add(new Person("856695", LocalDate.of(2009, 5, 15), "Manuel", "Antony"));
        persons.add(new Person("845845", LocalDate.of(1998, 9, 25), "Tatiana", "da Silva"));
        persons.add(new Person("128452", LocalDate.of(1985, 5, 3), "Mariana", "Vicentina"));
        persons.add(new Person("008487", LocalDate.of(2002, 2, 1), "Paulo", "André"));
        persons.add(new Person("154678", LocalDate.of(2007, 3, 12), "Gilberto", "Emerson"));
    }

    @Override
    public Boolean call() {
        if(this.persons.contains(person)) {
            return true;
        }
        return false;
    }
}
