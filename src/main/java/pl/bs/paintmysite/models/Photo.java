package pl.bs.paintmysite.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Photo {

    @Id
    @SequenceGenerator(name = "myPhotoGen", sequenceName = "myPhotoSeq", initialValue = 0, allocationSize = 100)
    @GeneratedValue(generator = "myPhotoGen")
    @Column(name = "id")
    private Long id;

    @Column(length = 10000)
    private String url;
    private Integer orderInProject;

    @Column(name = "project_id")
    private Long projectId;

    public Photo() {
    }
}
