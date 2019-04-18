package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.DTOmodel.ChorobyDTO;
import pwr.thesis.thesis.Service.ChorobyService;
import pwr.thesis.thesis.validator.ChorobyValidator;

@Controller
public class ChorobyController {

    private final ChorobyService chorobyService;
    private final ChorobyValidator chorobyValidator;


    @Autowired
    public ChorobyController(ChorobyService chorobyService, ChorobyValidator chorobyValidator) {
        this.chorobyService = chorobyService;
        this.chorobyValidator = chorobyValidator;
    }


    @GetMapping("/addChoroby")
    public String choroba(Model model) {
        model.addAttribute("choroby", new ChorobyDTO());
        return "addChoroba";
    }

    @PostMapping("save")
    public String addChoroba(ChorobyDTO choroby, BindingResult bindingResult) {
        chorobyValidator.validate(choroby, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/addChoroby";
        } else {
            chorobyService.addChoroba(choroby);
            return "startPage";
        }

    }

    @GetMapping("/allChoroby")
    public String allChoroby(Model model) {
        model.addAttribute("choroby", chorobyService.allChoroby());
        return "allChoroby";
    }

    @GetMapping("/choroba/{nazwa}")
    public String getChoroba(Model model, @PathVariable String nazwa) {
        model.addAttribute("choroba", chorobyService.findChoroba(nazwa));
        return "singleChoroba";
    }

    @PostMapping("update")
    public String update(ChorobyDTO chorobyDTO) {
        chorobyService.update(chorobyDTO);
        return "startPage";
    }
}
