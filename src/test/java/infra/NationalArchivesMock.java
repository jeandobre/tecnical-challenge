package infra;

import domain.NationalArchives;
import domain.Person;

import java.util.Arrays;
import java.util.List;

public final class NationalArchivesMock extends NationalArchives {

    private final List<String> archives;

    public NationalArchivesMock(Person person) {
        super(person);
        this.archives = Arrays.asList("123456", "748954", "14567", "154678", "157877", "14878");
    }

    @Override
    public Boolean call() throws Exception {
        return true;
    }
}
