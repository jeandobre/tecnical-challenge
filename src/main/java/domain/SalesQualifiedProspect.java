package domain;

import common.Subject;
import domain.Person;
import infra.InternalProspectQualification;
import infra.NationalArchives;
import infra.RegistryIdSystem;

public class SalesQualifiedProspect extends Subject {

    public SalesQualifiedProspect() {
        super();
        this
                .async(new NationalArchives())
                .async(new RegistryIdSystem())
                .join(new InternalProspectQualification());
    }

    public void prospect(Person person) throws InterruptedException {
        this.runNotify();
    }

}
