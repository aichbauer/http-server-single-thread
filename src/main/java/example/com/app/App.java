package example.com.app;

import example.com.app.controllers.CityController;
import example.com.app.services.CityService;
import example.com.http.ContentType;
import example.com.http.HttpStatus;
import lombok.AccessLevel;
import lombok.Setter;
import example.com.server.Request;
import example.com.server.Response;
import example.com.server.ServerApp;


public class App implements ServerApp {
    @Setter(AccessLevel.PRIVATE)
    private CityController cityController;

    public App() {
        setCityController(new CityController(new CityService()));
    }

    public Response handleRequest(Request request) {


        switch (request.getMethod()) {
            case GET: {
                if (request.getPathname().equals("/cities")) {
                    return this.cityController.getCities();
                }
            }
        }

        return new Response(HttpStatus.NOT_FOUND, ContentType.JSON, "{ \"error\": \"Not Found\", \"data\": null }");
    }
}
