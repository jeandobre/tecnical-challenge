import domain.Person;
import application.SalesQualifiedProspect;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

public class StartApplication {

    public static void main(String[] args) {

        Person person = new Person("123456", LocalDate.of(2010, 3, 7), "Jean", "Dobre");
        SalesQualifiedProspect service = new SalesQualifiedProspect(person);
        try {
            service.prospect();
        } catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }
    }
}
