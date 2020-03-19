package pl.bs.paintmysite.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.bs.paintmysite.controllers.msg.UserMsg;
import pl.bs.paintmysite.models.User;
import pl.bs.paintmysite.repositories.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User get() {
        return userRepository.findById(0L).orElseThrow(() -> new RuntimeException("There is no admin data in db"));
    }

    public void update(UserMsg userMsg) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userMsg, User.class);
        user.setId(0L);
        userRepository.save(user);
    }

}
