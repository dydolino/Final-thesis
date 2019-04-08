package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "loginForm";
    }


    @GetMapping("/zalogowany")
    @ResponseBody
    public String logged(Principal principal) {
        return "zalogowany użytkownik to " + principal.getName();
    }

}


