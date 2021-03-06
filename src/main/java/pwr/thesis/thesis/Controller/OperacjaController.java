package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.DTOmodel.OperacjaDTO;
import pwr.thesis.thesis.Service.*;
import pwr.thesis.thesis.validator.OperacjaValidator;

@Controller
public class OperacjaController {

    private OperacjaService operacjaService;
    private PacjentService pacjentService;
    private Egz_chorobyService egz_chorobyService;
    private LekarzService lekarzService;
    private SalaService salaService;
    private OperacjaValidator operacjaValidator;


    public OperacjaController(OperacjaService operacjaService, PacjentService pacjentService, Egz_chorobyService egz_chorobyService, LekarzService lekarzService, SalaService salaService, OperacjaValidator operacjaValidator) {
        this.operacjaService = operacjaService;
        this.pacjentService = pacjentService;
        this.egz_chorobyService = egz_chorobyService;
        this.lekarzService = lekarzService;
        this.salaService = salaService;
        this.operacjaValidator = operacjaValidator;
    }

    @GetMapping("/allOperacje")
    public String allOperacje(Model model) {
        model.addAttribute("operacje", operacjaService.findAll());
        return "allOperacje";
    }

    @GetMapping("/addOperacja")
    public String addOperacja(Model model) {
        model.addAttribute("operacja", new OperacjaDTO());
        model.addAttribute("pacjenci", pacjentService.allPacjenci());
        return "addOperacja";
    }

    @GetMapping("/addOperacja1")
    public String addOperacja1(OperacjaDTO operacja, Model model) {
        model.addAttribute("operacja", operacja);
        model.addAttribute("egzeplarze", egz_chorobyService.findAll(operacja.getPacjentPESEL()));
        return "addOperacja1";
    }

    @GetMapping("/addOperacja2")
    public String addOperacja2(OperacjaDTO operacja, Model model) {
        model.addAttribute("operacja", operacja);
        model.addAttribute("lekarze", lekarzService.findAll());
        return "addOperacja2";
    }

    @GetMapping("/addOperacja3")
    public String addOperacja3(OperacjaDTO operacja, Model model) {
        model.addAttribute("operacja", operacja);
        model.addAttribute("sale", salaService.findAll());
        return "addOperacja3";
    }

    @GetMapping("/addOperacja4")
    public String addOperacja4(OperacjaDTO operacja, Model model) {
        model.addAttribute("operacja", operacja);
        return "addOperacja4";
    }

    @GetMapping("/addOperacjaDoubled")
    public String addOperacjaDoubled(OperacjaDTO operacja, Model model) {
        model.addAttribute("operacja", operacja);
        return "addOperacjaDoubled";
    }

    @PostMapping("saveOperacja")
    public String saveOper(OperacjaDTO operacja, BindingResult bindingResult, Model model) {
        operacjaValidator.validate(operacja, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("operacja", operacja);
            return "addOperacjaDoubled";
        } else {
            operacjaService.addOperacja(operacja);
            return "redirect:/allOperacje";
        }
    }

    @GetMapping("/operacja/{id}")
    public String getOperacja(Model model, @PathVariable Integer id) {
        model.addAttribute("operacja", operacjaService.findOperacja(id));
        model.addAttribute("lekarze", lekarzService.findAll());
        model.addAttribute("sale", salaService.findAll());
        return "updateOperacja";
    }

    @PostMapping("updateOperacja")
    public String updateOperacja(OperacjaDTO operacja, BindingResult bindingResult, Model model) {
        operacjaValidator.validate(operacja, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("operacja", operacja);
            model.addAttribute("lekarze", lekarzService.findAll());
            model.addAttribute("sale", salaService.findAll());
            return "updateOperacjaDuplicaded";
        } else {
            operacjaService.update(operacja);
            return "redirect:/allOperacje";
        }
    }

    @GetMapping("/deleteOperacja/{id}")
    public String deleteOperacja(@PathVariable Integer id) {
        operacjaService.delete(id);

        return "redirect:/allOperacje";
    }
}
