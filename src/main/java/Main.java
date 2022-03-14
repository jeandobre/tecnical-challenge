import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);
    private static final int THREADS_COUNT = 1;
    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        //vertx.deployVerticle(new SensorVerticle());
        //vertx.deployVerticle("SensorVerticle", new DeploymentOptions().setInstances(4));
        vertx.deployVerticle("SensorVerticle", new DeploymentOptions().setInstances(THREADS_COUNT));
    }
}
