package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pwr.thesis.thesis.Model.User;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "loginForm";
    }

}


