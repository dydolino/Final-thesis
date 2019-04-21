package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.DTOmodel.LekarzDTO;
import pwr.thesis.thesis.Service.LekarzService;
import pwr.thesis.thesis.Service.SpecjalizacjaService;
import pwr.thesis.thesis.validator.LekarzValidator;

@Controller
public class LekarzController {

    private SpecjalizacjaService specjalizacjaService;
    private LekarzService lekarzService;
    private LekarzValidator lekarzValidator;

    public LekarzController(SpecjalizacjaService specjalizacjaService, LekarzService lekarzService, LekarzValidator lekarzValidator) {
        this.specjalizacjaService = specjalizacjaService;
        this.lekarzService = lekarzService;
        this.lekarzValidator = lekarzValidator;
    }

    @GetMapping("/addLekarz")
    public String add(Model model) {
        model.addAttribute("lekarz", new LekarzDTO());
        model.addAttribute("specjlaizacje", specjalizacjaService.findAll());
        return "addLekarz";
    }

    @PostMapping("saveLekarz")
    public String addChoroba(LekarzDTO lekarzDTO, BindingResult bindingResult) {
        lekarzValidator.validate(lekarzDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect:/addLekarz";
        } else {
            lekarzService.addLekarz(lekarzDTO);
            return "startPage";
        }
    }
}
