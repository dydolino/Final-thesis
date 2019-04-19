package pwr.thesis.thesis.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pwr.thesis.thesis.Model.Specjalizacja;
import pwr.thesis.thesis.Repository.SpecjalizacjaRepository;

@Controller
public class SpecjalizacjaController {

    private SpecjalizacjaRepository specjalizacjaRepository;

    public SpecjalizacjaController(SpecjalizacjaRepository specjalizacjaRepository) {
        this.specjalizacjaRepository = specjalizacjaRepository;
    }

    //TODO refaktoryzacja - dodanie DTO
    @GetMapping("/addSpecjalizcja")
    public String add(Model model) {
        model.addAttribute("specjalizacja", new Specjalizacja());
        return "addSpecjalizacja";
    }

    //TODO refaktoryzacja - dodanie serwisu
    @PostMapping("saveSpecjalizacja")
    public String addChoroba(Specjalizacja specjalizacja) {

        specjalizacjaRepository.save(specjalizacja);
        return "startPage";
    }
}
