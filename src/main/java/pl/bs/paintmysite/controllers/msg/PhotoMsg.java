package pl.bs.paintmysite.controllers.msg;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class PhotoMsg {

    private final String url;
    private final Integer orderInProject;
    private final Long projectId;


    @JsonCreator
    public PhotoMsg(@JsonProperty("url") String url,
                    @JsonProperty("orderInProject") Integer orderInProject,
                    @JsonProperty("projectId") Long projectId) {
        this.url = url;
        this.orderInProject = orderInProject;
        this.projectId = projectId;
    }
}
