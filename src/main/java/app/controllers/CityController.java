package app.controllers;

import app.services.CityService;
import com.fasterxml.jackson.core.JsonProcessingException;
import http.ContentType;
import http.HttpStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import server.Response;

import java.util.List;

public class CityController extends Controller {
    @Setter(AccessLevel.PRIVATE)
    @Getter(AccessLevel.PRIVATE)
    private CityService cityService;

    public CityController(CityService cityService) {
        setCityService(cityService);
    }

    // DELETE /cities/:id -> löscht eine city mit der id
    // POST /cities -> erstellt eine neue city
    // PUT/PATCH /cities/:id -> updated eine city mit der id
    // GET /cities/:id -> die eine city zurück mit der id
    // GET /cities -> alle cities zurück
    public Response getCities() {
        try {
            List cityData = getCityService().getCities();
            String cityDataJSON = getObjectMapper().writeValueAsString(cityData);

            return new Response(
                HttpStatus.OK,
                ContentType.JSON,
                "{ \"data\": " + cityDataJSON + ", \"error\": null }"
            );
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return new Response(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ContentType.JSON,
                "{ \"error\": \"Internal Server Error\", \"data\": null }"
            );
        }
    }

    // GET /cities/:id
    public void getCityById(int id) {

    }

    // POST /cities
    public void createCity() {

    }

    // DELETE /cities/:id
    public void deleteCity(int id) {

    }
}
