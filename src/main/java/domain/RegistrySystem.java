package domain;

import java.util.concurrent.Callable;

public abstract class RegistrySystem implements Callable<Boolean> {

    protected Person person;

    protected RegistrySystem(Person person) {
        this.person = person;
    }
}
