package pl.bs.paintmysite.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class User {

    @Id
    @SequenceGenerator(name = "myUserGen", sequenceName = "myUserSeq", initialValue = 0, allocationSize = 100)
    @GeneratedValue(generator = "myUserGen")
    @Column(name = "id")
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;
    private String profilePictureUrl;
    private String aboutMe;

    public User() {
    }

}
