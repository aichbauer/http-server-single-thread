package example.com;

import example.com.app.App;
import example.com.server.Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        Server server = new Server(app, 7777);
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
