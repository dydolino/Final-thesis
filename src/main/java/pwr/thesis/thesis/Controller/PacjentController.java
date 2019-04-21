package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.DTOmodel.PacjentDTO;
import pwr.thesis.thesis.Service.PacjentService;
import pwr.thesis.thesis.validator.PacjentValidator;

@Controller
public class PacjentController {

    private PacjentService pacjentService;
    private PacjentValidator pacjentValidator;

    @Autowired
    public PacjentController(PacjentService pacjentService, PacjentValidator pacjentValidator) {
        this.pacjentService = pacjentService;
        this.pacjentValidator = pacjentValidator;
    }

    @GetMapping("/addPacjent")
    public String pacjent(Model model) {
        model.addAttribute("pacjent", new PacjentDTO());
        return "addPacjent";
    }

    @PostMapping("savePacjent")
    public String addPacjent(PacjentDTO pacjentDTO, BindingResult bindingResult) {
        pacjentValidator.validate(pacjentDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/addPacjent";
        } else {
            pacjentService.addPacjent(pacjentDTO);
            return "startPage";
        }

    }

    @GetMapping("/allPacjenci")
    public String allChoroby(Model model) {
        model.addAttribute("pacjenci", pacjentService.allPacjenci());
        return "allPacjenci";
    }

    @GetMapping("/pacjent/{pesel}")
    public String getChoroba(Model model, @PathVariable String pesel) {
        model.addAttribute("pacjent", pacjentService.findPacjent(pesel));
        return "singlePacjent";
    }

    @PostMapping("updatePacjent")
    public String updatePacjent(PacjentDTO pacjentDTO) {
        pacjentService.update(pacjentDTO);
        return "redirect:/allPacjenci";
    }

    //TODO delete method
}
