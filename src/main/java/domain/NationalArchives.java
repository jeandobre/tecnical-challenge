package domain;

import common.Observer;

public abstract class NationalArchives implements Observer {

    private Boolean hasJudicialRecord;
    private Person person;

    protected NationalArchives(Person person) {
        this.person = person;
        this.hasJudicialRecord = Boolean.FALSE;
    }

    @Override
    public void run() {

        System.out.println("Begin Registry ID system");
        this.hookHttpRequest(person);
    }

    public Boolean isValid() {
        return this.hasJudicialRecord;
    }

    protected abstract void hookHttpRequest(Person person);

    protected void personHasJudicialRecord() {
        this.hasJudicialRecord = Boolean.TRUE;
    }
}
