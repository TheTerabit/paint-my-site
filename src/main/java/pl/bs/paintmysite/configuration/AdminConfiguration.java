package pl.bs.paintmysite.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bs.paintmysite.models.User;
import pl.bs.paintmysite.repositories.UserRepository;

@Configuration
public class AdminConfiguration {

    private final UserRepository userRepository;

    public AdminConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public void configureAdminAccount() {
        userRepository.save(createAdmin());
    }

    private User createAdmin() {
        User user = new User();
        user.setId(0L);
        user.setName("Marta");
        user.setSurname("Szczepańczyk");
        user.setJobTitle("Architect / Graphic designer / Artist / Painter");
        user.setAboutMe("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus. Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci. Nam congue, pede vitae dapibus aliquet, elit magna vulputate arcu, vel tempus metus leo non est. Etiam sit amet lectus quis est congue mollis. Phasellus congue lacus eget neque. Phasellus ornare, ante vitae consectetuer consequat, purus sapien ultricies dolor, et mollis pede metus eget nisi. Praesent sodales velit quis augue. Cras suscipit, urna at aliquam rhoncus, urna quam viverra nisi, in interdum massa nibh nec erat.");
        user.setEmail("theterabit@gmail.com");
        user.setPhoneNumber("123456789");
        user.setProfilePictureUrl("https://scontent-waw1-1.xx.fbcdn.net/v/t1.0-9/p960x960/76747498_2410765555718521_9194958319930834944_o.jpg?_nc_cat=110&_nc_sid=85a577&_nc_ohc=VRMdNi7OTQAAX_Ju-yS&_nc_ht=scontent-waw1-1.xx&_nc_tp=6&oh=819a4232585ffd07742fdf9a9472bf64&oe=5ED5D321");

        return user;
    }

}
