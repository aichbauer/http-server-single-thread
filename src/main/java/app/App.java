package app;

import app.controllers.CityController;
import app.services.CityService;
import http.ContentType;
import http.HttpStatus;
import lombok.AccessLevel;
import lombok.Setter;
import server.Request;
import server.Response;
import server.ServerApp;


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
