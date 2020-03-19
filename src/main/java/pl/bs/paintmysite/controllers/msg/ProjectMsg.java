package pl.bs.paintmysite.controllers.msg;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProjectMsg {

    private final String name;
    private final String description;
    private final Long categoryId;

    @JsonCreator
    public ProjectMsg(@JsonProperty("name") String name,
                      @JsonProperty("description") String description,
                      @JsonProperty("categoryId") Long categoryId) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
    }
}
