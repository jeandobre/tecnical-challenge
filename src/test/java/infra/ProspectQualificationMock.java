package infra;

import domain.Person;
import domain.ProspectQualification;

public class ProspectQualificationMock extends ProspectQualification {

    private Integer score;

    public ProspectQualificationMock(Person person, Integer score) {
        super(person);
        this.score = score;
    }

    @Override
    public Boolean call() {
        return (score > 60);
    }
}
