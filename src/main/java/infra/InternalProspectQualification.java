package infra;

import common.Observer;

public class InternalProspectQualification implements Observer {

    @Override
    public void run() {

        System.out.println("Internal prospect qualification");
    }
}
