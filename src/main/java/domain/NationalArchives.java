package domain;

import java.util.concurrent.Callable;

public abstract class NationalArchives implements Callable<Boolean> {

    protected Person person;

    protected NationalArchives(Person person) {
        this.person = person;
    }
}
