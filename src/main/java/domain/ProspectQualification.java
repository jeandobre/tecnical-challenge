package domain;

import common.Observer;

import java.util.concurrent.Callable;

public abstract class ProspectQualification implements Callable<Boolean> {

    private int score = 0;
    private Person person;

    protected ProspectQualification(Person person) {
        this.person = person;
    }
}
