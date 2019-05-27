package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.DTOmodel.OperacjaDTO;
import pwr.thesis.thesis.Service.*;

@Controller
public class OperacjaController {

    private OperacjaService operacjaService;
    private PacjentService pacjentService;
    private Egz_chorobyService egz_chorobyService;
    private LekarzService lekarzService;
    private SalaService salaService;


    public OperacjaController(OperacjaService operacjaService, PacjentService pacjentService, Egz_chorobyService egz_chorobyService, LekarzService lekarzService, SalaService salaService) {
        this.operacjaService = operacjaService;
        this.pacjentService = pacjentService;
        this.egz_chorobyService = egz_chorobyService;
        this.lekarzService = lekarzService;
        this.salaService = salaService;
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
        model.addAttribute("sale", salaService.findAll());
        return "addOperacja4";
    }

    @PostMapping("saveOperacja")
    public String saveOper(OperacjaDTO operacja, BindingResult bindingResult) {
        //TODO implementacja operacjaValidator
        if (bindingResult.hasErrors()) {
            //TODO co jesli sala jest wtedy zajeta
            return "/addOperacja4";
        } else {
        operacjaService.addOperacja(operacja);
            return "redirect:/allOperacje";
        }
    }

    //TODO modifyOperacja
}
