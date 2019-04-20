package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.DTOmodel.SpecjalizacjaDTO;
import pwr.thesis.thesis.Service.SpecjalizacjaService;
import pwr.thesis.thesis.validator.SpecjalizacjaValidator;

@Controller
public class SpecjalizacjaController {

    private SpecjalizacjaValidator specjalizacjaValidator;
    private SpecjalizacjaService specjalizacjaService;

    @Autowired
    public SpecjalizacjaController(SpecjalizacjaValidator specjalizacjaValidator, SpecjalizacjaService specjalizacjaService) {
        this.specjalizacjaService = specjalizacjaService;
        this.specjalizacjaValidator = specjalizacjaValidator;
    }

    @GetMapping("/addSpecjalizcja")
    public String add(Model model) {
        model.addAttribute("specjalizacja", new SpecjalizacjaDTO());
        return "addSpecjalizacja";
    }


    @PostMapping("saveSpecjalizacja")
    public String addChoroba(SpecjalizacjaDTO specjalizacjaDTO, BindingResult bindingResult) {
        specjalizacjaValidator.validate(specjalizacjaDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/addSpecjalizcja";
        } else {
            specjalizacjaService.saveSpecjalizacja(specjalizacjaDTO);
        }
        return "startPage";
    }
}
