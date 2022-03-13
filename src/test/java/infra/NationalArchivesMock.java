package infra;

import domain.NationalArchives;
import domain.Person;

import java.util.Arrays;
import java.util.List;

public final class NationalArchivesMock extends NationalArchives {

    private final List<String> judicialFecords;

    public NationalArchivesMock(Person person) {
        super(person);
        this.judicialFecords = Arrays.asList("748954", "14567", "154678", "157877", "14878");
    }

    @Override
    public Boolean call() {
        return !this.judicialFecords.contains(person.nationalIdNumber());
    }
}
