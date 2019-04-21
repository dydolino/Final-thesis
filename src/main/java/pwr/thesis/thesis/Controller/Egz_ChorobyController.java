package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pwr.thesis.thesis.Service.Egz_chorobyService;

@Controller
public class Egz_ChorobyController {

    private Egz_chorobyService egz_chorobyService;

    public Egz_ChorobyController(Egz_chorobyService egz_chorobyService) {
        this.egz_chorobyService = egz_chorobyService;
    }

    @GetMapping("/egzChoroby/{pesel}")
    public String chorobyPacjenta(@PathVariable String pesel, Model model) {
        if (egz_chorobyService.findByPesel(pesel)) {
            return "redirect:/allPacjenciErrorChoroby";
        } else {
            model.addAttribute("egzChoroby", egz_chorobyService.findAll(pesel));
            return "chorobyPacjenta";
        }
    }
}
