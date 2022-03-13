package infra;

import common.TimeLatency;
import domain.RegistrySystem;
import domain.Person;

public final class RegistrySystemHttp extends RegistrySystem {

    final long latency;
    public RegistrySystemHttp(final Person person, final long latency) {
        super(person);
        this.latency = latency;
    }

    @Override
    public Boolean call() {
        System.out.println("[Registry system] - started");

        TimeLatency.simulateLatency(this.latency);

        if(this.person.fullName().equals("Jean Dobre")) {
            System.out.println("[Registry system] - Approved");
            return true;
        }

        System.out.println("[Registry system] - Not approved");
        return false;
    }
}
