package pl.coderslab.charity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.UserRepository;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(Model model){
        model.addAttribute("user",new User());
        return "register-user";
    }
}
