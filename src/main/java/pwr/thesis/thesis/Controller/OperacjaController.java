package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.DTOmodel.OperacjaDTO;
import pwr.thesis.thesis.Service.Egz_chorobyService;
import pwr.thesis.thesis.Service.LekarzService;
import pwr.thesis.thesis.Service.OperacjaService;
import pwr.thesis.thesis.Service.PacjentService;

@Controller
public class OperacjaController {

    private OperacjaService operacjaService;
    private PacjentService pacjentService;
    private Egz_chorobyService egz_chorobyService;
    private LekarzService lekarzService;


    public OperacjaController(OperacjaService operacjaService, PacjentService pacjentService, Egz_chorobyService egz_chorobyService, LekarzService lekarzService) {
        this.operacjaService = operacjaService;
        this.pacjentService = pacjentService;
        this.egz_chorobyService = egz_chorobyService;
        this.lekarzService = lekarzService;
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

    @PostMapping("saveOperacja")
    public String saveOper(OperacjaDTO operacja) {

        //TODO dodanie sali, wydarzen i daty - dziala dodawanie lekarza, pacjenta, egz choroby
        operacjaService.addOperacja(operacja);

        return "allOperacje";
    }

    //TODO modifyOperacja
}
