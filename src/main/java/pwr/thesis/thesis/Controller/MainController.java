package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String start(Principal principal, Model model){
        model.addAttribute("uzytkownik", principal);
        return "startPagepoLogin";
    }
}
