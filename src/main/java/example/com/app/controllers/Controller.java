package example.com.app.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

public class Controller {
    @Getter
    @Setter
    private ObjectMapper objectMapper;

    public Controller() {
        setObjectMapper(new ObjectMapper());
    }
}
