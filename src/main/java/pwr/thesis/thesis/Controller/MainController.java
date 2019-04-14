package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pwr.thesis.thesis.Model.User;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String start(Principal principal, Model model){
        model.addAttribute("user", new User());
        model.addAttribute("uzytkownik", principal);
        return "startPagepoLogin";
    }
}
