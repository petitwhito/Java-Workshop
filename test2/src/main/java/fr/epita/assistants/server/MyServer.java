package fr.epita.assistants.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.net.HttpURLConnection.HTTP_OK;

public class MyServer {

    private static HttpServer server = null;
    private static ExecutorService executor;


    public static void launchServer() throws IOException {
        server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        executor = Executors.newFixedThreadPool(10);
        server.setExecutor(executor);
        var context = server.createContext("/");
        context.setHandler((arg) -> {
            try {
                Thread.sleep(1500);
                arg.sendResponseHeaders(HTTP_OK, 0);
                arg.close();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        server.start();
    }


    public static void stopServer() {
        if (server == null)
            return;
        server.stop(0);
        executor.shutdownNow();
    }
}
