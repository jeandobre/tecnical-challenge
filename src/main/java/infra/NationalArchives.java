package infra;

import common.Observer;

public class NationalArchives implements Observer {

    @Override
    public void run() {
        System.out.println("Acessar national Archives");
    }
}
