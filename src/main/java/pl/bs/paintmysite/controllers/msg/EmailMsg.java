package pl.bs.paintmysite.controllers.msg;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class EmailMsg {

    private final String name;
    private final String email;
    private final String message;

    @JsonCreator
    public EmailMsg(@JsonProperty("name") String name,
                       @JsonProperty("email") String email,
                       @JsonProperty("message") String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }
}
