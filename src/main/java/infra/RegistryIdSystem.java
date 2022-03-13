package infra;

import common.Observer;

public class RegistryIdSystem implements Observer {

    @Override
    public void run() {

        System.out.println("Begin Registry ID system");
        try {
            Thread.sleep(5000);
        } catch(InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("Acessar HTTP: Registry ID System");
    }
}
