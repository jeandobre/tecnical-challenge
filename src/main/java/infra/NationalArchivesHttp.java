package infra;

import domain.NationalArchives;
import domain.Person;

public final class NationalArchivesHttp extends NationalArchives {

    public NationalArchivesHttp(Person person) {
        super(person);
    }

    @Override
    public Boolean call() {
        if(this.person.nationalIdNumber().equals("123456")){
            System.out.println("[National Archives] - Approved");
            return true;
        }
        System.out.println("[National Archives] - Not Approved");
        return false;
    }
}
