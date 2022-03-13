package application;

import common.Subject;
import domain.NationalArchives;
import domain.Person;
import domain.ProspectQualification;
import domain.RegistrySystem;
import infra.NationalArchivesHttp;
import infra.ProspectQualificationHttp;
import infra.RegistrySystemHttp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class SalesQualifiedProspect {

    private final RegistrySystem registrySystem;
    private final NationalArchives nationalArchives;
    private final ProspectQualification prospectQualification;

    public SalesQualifiedProspect(Person person) {
        super();
        nationalArchives = new NationalArchivesHttp(person);
        registrySystem = new RegistrySystemHttp(person);
        prospectQualification = new ProspectQualificationHttp(person);
    }

    public void prospect() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Boolean> future1 = pool.submit(nationalArchives);
        Future<Boolean> future2 = pool.submit(registrySystem);

        if(future1.get() && future2.get()) {
            if(pool.submit(prospectQualification).get()) {
                System.out.println("Approved!");
                pool.shutdown();
                return;
            }
        }
        System.out.println("Not Approved!");
        pool.shutdown();
    }
}
