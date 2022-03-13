package infra;

import domain.RegistrySystem;
import domain.Person;

public final class RegistrySystemHttp extends RegistrySystem {

    public RegistrySystemHttp(Person person) {
        super(person);
    }

    @Override
    public Boolean call() {
        if(this.person.fullName().equals("Jean Dobre")) {
            System.out.println("[Registry system] - Approved");
            return true;
        }

        System.out.println("[Registry system] - Not approved");
        return false;
    }
}
