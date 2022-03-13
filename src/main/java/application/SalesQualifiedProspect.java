package application;

import domain.NationalArchives;
import domain.ProspectQualification;
import domain.RegistrySystem;
import java.util.concurrent.*;

public final class SalesQualifiedProspect {

    private final RegistrySystem registrySystem;
    private final NationalArchives nationalArchives;
    private final ProspectQualification prospectQualification;

    private Boolean approved;

    public SalesQualifiedProspect(RegistrySystem registrySystem,
                                  NationalArchives nationalArchives,
                                  ProspectQualification prospectQualification) {
        this.registrySystem = registrySystem;
        this.nationalArchives = nationalArchives;
        this.prospectQualification = prospectQualification;
    }

    public void prospect() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Boolean> future1 = pool.submit(nationalArchives);
        Future<Boolean> future2 = pool.submit(registrySystem);
        this.approved = Boolean.FALSE;
        if(future1.get() && future2.get()) {
            if(pool.submit(prospectQualification).get()) {
                approved = Boolean.TRUE;
            }
        }

        System.out.println(approved ? "Approved!" : "Not Approved!");
        pool.shutdown();
    }
}
