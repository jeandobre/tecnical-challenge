package application;

import common.Subject;
import domain.Person;
import infra.NationalArchivesHttp;
import infra.ProspectQualificationHttp;
import infra.RegistrySystemHttp;

public class SalesQualifiedProspect extends Subject {

    public SalesQualifiedProspect(Person person) {
        super();
        this
            .async(new RegistrySystemHttp(person))
            .async(new NationalArchivesHttp(person))
            .join(new ProspectQualificationHttp(person));
    }

    public void prospect() throws InterruptedException {
        this.runNotify();
    }

}
