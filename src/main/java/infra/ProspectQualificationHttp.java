package infra;

import common.TimeLatency;
import domain.Person;
import domain.ProspectQualification;

public final class ProspectQualificationHttp extends ProspectQualification {

    final long latency;
    public ProspectQualificationHttp(final Person person, final long latency) {
        super(person);
        this.latency = latency;
    }

    @Override
    public Boolean call() {
        System.out.print("[Internal prospect]");
        TimeLatency.simulateLatency(this.latency);

        int score = ((int) (Math.random() * 100));
        System.out.println(" - Our Score: " + score);
        return score > 60;
    }
}
