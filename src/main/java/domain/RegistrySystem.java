package domain;

import common.Observer;

public abstract class RegistrySystem implements Observer {

    private Boolean exists;
    private Person person;

    protected RegistrySystem(Person person) {
        this.person = person;
        this.exists = Boolean.FALSE;
    }

    @Override
    public void run() {
        System.out.println("Acessar national Archives");
        this.hookHttpRequest(this.person);
    }

    public abstract void hookHttpRequest(Person person);

    public Boolean isValid() {
        return this.exists;
    }

    protected void personExists() {
        this.exists = Boolean.TRUE;
    }
}
