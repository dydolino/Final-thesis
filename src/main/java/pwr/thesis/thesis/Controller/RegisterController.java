package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.Model.User;
import pwr.thesis.thesis.Service.UserService;
import pwr.thesis.thesis.validator.UserValidator;

import java.security.Principal;

@Controller
public class RegisterController {

    UserService userService;
    UserValidator userValidator;

    @Autowired
    public RegisterController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/registration")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/saveUser")
    public String addUser(User user, Principal principal, Model model, BindingResult bindingResult) {
        userValidator.validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return "redirect:/registration";
        }else {
        userService.saveUser(user.getUsername(), user.getPassword());
        model.addAttribute("uzytkownik", principal);
        return "startPageAfterNewUser";
        }
    }
}
