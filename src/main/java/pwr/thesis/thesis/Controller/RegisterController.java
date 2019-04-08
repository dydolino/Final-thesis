package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.Model.User;
import pwr.thesis.thesis.Service.UserService;

@Controller
public class RegisterController {

    UserService userService;

    @Autowired
    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registerUser")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/saveUser")
    public String addUser(User user) {
        userService.saveUser(user.getUsername(), user.getPassword());
        return "startPage";
    }
}
