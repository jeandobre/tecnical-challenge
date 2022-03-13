import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import java.util.Scanner;

public class StartApplication {

    public static void main(String[] args) {

        Vertx vertx = Vertx.vertx();
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(request -> {
            System.out.println("Came to hello");
            request.response().setChunked(true);
            request.response().write("Hello world!");
            // request.response().end("hello world!");
        });

        server.listen(8081);
/*
        Boolean system = true;
        Scanner scanner = new Scanner(System.in);
        while (system) {
            System.out.println("Qual ação você quer executar");
            System.out.println("0 - Close");
            System.out.println("1 - Validate prospect");

            int action = scanner.nextInt();
            if (action == 1) {
                //do
            }
            system = (action != 0);
        }*/
    }
}
