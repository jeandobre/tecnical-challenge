package infra;

import domain.RegistrySystem;
import domain.Person;

public final class RegistrySystemHttp extends RegistrySystem {

    public RegistrySystemHttp(Person person) {
        super(person);
    }

    @Override
    public void hookHttpRequest(Person person) {
        if(person.fullName().equals("Jean Dobre")) this.personExists();
    }
}
