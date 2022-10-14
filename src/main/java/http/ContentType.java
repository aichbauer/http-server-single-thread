package http;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public enum ContentType {
    HTML("text/html"),
    TEXT("text/plain"),
    JSON("application/json");

    @Getter
    @Setter(AccessLevel.PRIVATE)
    private String type;

    ContentType(String type) {
        setType(type);
    }
}
