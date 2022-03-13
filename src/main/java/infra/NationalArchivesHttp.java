package infra;

import domain.NationalArchives;
import domain.Person;

public final class NationalArchivesHttp extends NationalArchives {

    public NationalArchivesHttp(Person person) {
        super(person);
    }

    @Override
    public void hookHttpRequest(Person person) {
        if(person.nationalIdNumber().equals("123456")) this.personHasJudicialRecord();
    }
}
