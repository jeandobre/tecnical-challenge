package infra;

import domain.Person;
import domain.ProspectQualification;

public final class ProspectQualificationHttp extends ProspectQualification {

    public ProspectQualificationHttp(Person person) {
        super(person);
    }

    @Override
    public Boolean call() {
        int score = ((int) (Math.random() * 100));
        System.out.println("Our Score: " + score);
        return score > 60;
    }
}
