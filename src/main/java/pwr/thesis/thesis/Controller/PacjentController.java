package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.DTOmodel.PacjentDTO;
import pwr.thesis.thesis.Service.Egz_chorobyService;
import pwr.thesis.thesis.Service.PacjentService;
import pwr.thesis.thesis.validator.PacjentValidator;

@Controller
public class PacjentController {

    private PacjentService pacjentService;
    private PacjentValidator pacjentValidator;
    private Egz_chorobyService egz_chorobyService;

    @Autowired
    public PacjentController(PacjentService pacjentService, PacjentValidator pacjentValidator, Egz_chorobyService egz_chorobyService) {
        this.pacjentService = pacjentService;
        this.pacjentValidator = pacjentValidator;
        this.egz_chorobyService = egz_chorobyService;
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
    public String allPacjenci(Model model) {
        model.addAttribute("pacjenci", pacjentService.allPacjenci());
        return "allPacjenci";
    }

    @GetMapping("/allPacjenciError")
    public String allPacjenciError(Model model) {
        model.addAttribute("pacjenci", pacjentService.allPacjenci());
        return "allPacjenciError";
    }

    @GetMapping("/allPacjenciErrorChoroby")
    public String allPacjenciErrorChoroby(Model model) {
        model.addAttribute("pacjenci", pacjentService.allPacjenci());
        return "allPacjenciErrorChoroby";
    }

    @GetMapping("/pacjent/{pesel}")
    public String getPacjent(Model model, @PathVariable String pesel) {
        model.addAttribute("pacjent", pacjentService.findPacjent(pesel));
        return "singlePacjent";
    }

    @PostMapping("updatePacjent")
    public String updatePacjent(PacjentDTO pacjentDTO) {
        pacjentService.update(pacjentDTO);
        return "redirect:/allPacjenci";
    }

    @GetMapping("/deletePacjent/{pesel}")
    public String deletePacjent(@PathVariable String pesel) {
        if (pacjentService.delete(pesel)) {
            return "redirect:/allPacjenci";
        } else return "redirect:/allPacjenciError";
    }
}
