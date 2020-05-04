package pl.bs.paintmysite.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Project {

    @Id
    @SequenceGenerator(name = "myProjectGen", sequenceName = "myProjectSeq", initialValue = 0, allocationSize = 100)
    @GeneratedValue(generator = "myProjectGen")
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="project_id", referencedColumnName = "id")
    private List<Photo> photos;

    @Column(name = "category_id")
    private Long categoryId;


    public Project() {
    }

}
