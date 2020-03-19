package pl.bs.paintmysite.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Category {

    @Id
    @SequenceGenerator(name = "myCategorySeqGen", sequenceName = "myCategorySeq", initialValue = 0, allocationSize = 100)
    @GeneratedValue(generator = "myCategorySeqGen")
    @Column(name = "id")
    private Long id;
    private String name;
    private String description;
    private String photoUrl;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private List<Project> projects;

    public Category() {
    }

}
