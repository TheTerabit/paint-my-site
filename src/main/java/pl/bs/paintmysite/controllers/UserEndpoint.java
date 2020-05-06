package pl.bs.paintmysite.controllers;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.web.bind.annotation.*;
import pl.bs.paintmysite.controllers.msg.UserMsg;
import pl.bs.paintmysite.models.User;
import pl.bs.paintmysite.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserEndpoint {

    private final UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User get() {
        return userService.get();
    }

    @PutMapping
    public void update(@RequestBody UserMsg userMsg) {
        userService.update(userMsg);
    }

    @PostMapping
    public String post() {
        return "OK";
    }

}
