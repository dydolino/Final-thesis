package pwr.thesis.thesis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pwr.thesis.thesis.Service.OperacjaService;

@Controller
public class OperacjaController {

    private OperacjaService operacjaService;

    @Autowired
    public OperacjaController(OperacjaService operacjaService) {
        this.operacjaService = operacjaService;
    }

    @GetMapping("/allOperacje")
    public String allOperacje(Model model) {
        model.addAttribute("operacje", operacjaService.findAll());
        return "allOperacje";
    }
}
