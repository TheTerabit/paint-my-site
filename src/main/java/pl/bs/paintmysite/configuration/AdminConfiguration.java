package pl.bs.paintmysite.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
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
        user.setName("Jan");
        user.setSurname("Kowalski");
        user.setAboutMe("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin nibh augue, suscipit a, scelerisque sed, lacinia in, mi. Cras vel lorem. Etiam pellentesque aliquet tellus. Phasellus pharetra nulla ac diam. Quisque semper justo at risus. Donec venenatis, turpis vel hendrerit interdum, dui ligula ultricies purus, sed posuere libero dui id orci. Nam congue, pede vitae dapibus aliquet, elit magna vulputate arcu, vel tempus metus leo non est. Etiam sit amet lectus quis est congue mollis. Phasellus congue lacus eget neque. Phasellus ornare, ante vitae consectetuer consequat, purus sapien ultricies dolor, et mollis pede metus eget nisi. Praesent sodales velit quis augue. Cras suscipit, urna at aliquam rhoncus, urna quam viverra nisi, in interdum massa nibh nec erat.");
        user.setEmail("jan@kowalski.pl");
        user.setPhoneNumber("123456789");
        user.setProfilePictureUrl("https://avatars1.githubusercontent.com/u/36801835?s=460&u=8483c9b9d1d31289f80d06604a22e905b448cf5c&v=4");

        return user;
    }

}
