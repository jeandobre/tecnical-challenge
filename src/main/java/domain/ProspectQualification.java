package domain;

import common.Observer;

public abstract class ProspectQualification implements Observer {

    private int score = 0;
    private Person person;

    protected ProspectQualification(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
       this.hookHttpRequest();
    }

    protected abstract void hookHttpRequest();

    public void score(int score) {
        this.score = score;
    }

    public int score() {
        return score;
    }

    @Override
    public Boolean isValid() {
        return this.score > 60;
    }
}
