package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.Model.Specjalizacja;
import pwr.thesis.thesis.Repository.SpecjalizacjeRepository;

import java.util.List;

@Controller
public class SpecjalizacjaController {

    private SpecjalizacjeRepository specjalizacjeRepository;

    public SpecjalizacjaController(SpecjalizacjeRepository specjalizacjeRepository) {
        this.specjalizacjeRepository = specjalizacjeRepository;
    }

    @GetMapping("/addSpecjalizcja")
    public String add(Model model){
        model.addAttribute("specjalizacja",new Specjalizacja());
        return "addSpecjalizacja";
    }

    @PostMapping("saveSpecjalizacja")
    public String addChoroba(Specjalizacja specjalizacja) {

        specjalizacjeRepository.save(specjalizacja);
        return "startPage";
    }
}
