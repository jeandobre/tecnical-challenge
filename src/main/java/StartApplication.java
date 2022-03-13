import domain.Person;
import application.SalesQualifiedProspect;

import java.time.LocalDate;

public class StartApplication {

    public static void main(String[] args) {

        Person person = new Person("124875", LocalDate.of(2010, 3, 7), "Jean", "Dobre");
        SalesQualifiedProspect service = new SalesQualifiedProspect(person);
        try {
            service.prospect();
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
}
