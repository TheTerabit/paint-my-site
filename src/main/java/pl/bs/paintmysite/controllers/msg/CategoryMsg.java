package pl.bs.paintmysite.controllers.msg;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CategoryMsg {

    private final String name;
    private final String description;
    private final String photoUrl;

    @JsonCreator
    public CategoryMsg(@JsonProperty("name") String name,
                       @JsonProperty("description") String description,
                       @JsonProperty("photoUrl") String photoUrl) {
        this.name = name;
        this.description = description;
        this.photoUrl = photoUrl;
    }



}
