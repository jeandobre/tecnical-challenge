import domain.NationalArchives;
import domain.Person;
import application.SalesQualifiedProspect;
import domain.ProspectQualification;
import domain.RegistrySystem;
import infra.NationalArchivesHttp;
import infra.ProspectQualificationHttp;
import infra.RegistrySystemHttp;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

public class StartApplication {

    public static void main(String[] args) {

        Person person = new Person("123456", LocalDate.of(2010, 3, 7), "Jean", "Dobre");

        RegistrySystem registrySystem = new RegistrySystemHttp(person);
        NationalArchives nationalArchives = new NationalArchivesHttp(person);
        ProspectQualification prospectQualification = new ProspectQualificationHttp(person);

        SalesQualifiedProspect service = new SalesQualifiedProspect(registrySystem, nationalArchives, prospectQualification);
        try {
            service.prospect();
        } catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
    }
}
