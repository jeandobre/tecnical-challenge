package infra;

import common.TimeLatency;
import domain.NationalArchives;
import domain.Person;

public final class NationalArchivesHttp extends NationalArchives {

    final long latency;

    public NationalArchivesHttp(final Person person, final long latency) {
        super(person);
        this.latency = latency;
    }

    @Override
    public Boolean call() {
        System.out.println("[National Archives] - started");
        TimeLatency.simulateLatency(this.latency);

        if(this.person.nationalIdNumber().equals("123456")){
            System.out.println("[National Archives] - Approved");
            return true;
        }
        System.out.println("[National Archives] - Not Approved");
        return false;
    }
}
