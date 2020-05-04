package pl.bs.paintmysite.controllers.msg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.codehaus.jackson.annotate.JsonCreator;

@Getter
public class UserMsg {

    private final String name;
    private final String surname;
    private final String jobTitle;
    private final String phoneNumber;
    private final String email;
    private final String profilePictureUrl;
    private final String aboutMe;

    @JsonCreator
    public UserMsg(@JsonProperty("name") String name,
                   @JsonProperty("surname") String surname,
                   @JsonProperty("jobTitle") String jobTitle,
                   @JsonProperty("phoneNumber") String phoneNumber,
                   @JsonProperty("email") String email,
                   @JsonProperty("profilePictureUrl") String profilePictureUrl,
                   @JsonProperty("aboutMe") String aboutMe) {
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.profilePictureUrl = profilePictureUrl;
        this.aboutMe = aboutMe;
    }
}
